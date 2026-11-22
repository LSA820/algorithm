package boj.dfs03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static int[] depth;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 노드 개수
		int M = sc.nextInt(); // 간선 개수
		int R = sc.nextInt(); // 시작 노드
		
		depth = new int[N+1];
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		
		//깊이 초기화
		Arrays.fill(depth, -1);
		depth[R] = 0;
		
		//그래프 초기화
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList());
		}
		
		// 그래프 입력
		for(int i=0; i<M; i++) {
			int u = sc.nextInt(); // 현재 노드 
			int v = sc.nextInt(); // 다음 노드
			
			graph.get(u).add(v);
			graph.get(v).add(u); // 무방향 그래프
		}
		
		// 오름차순을 위한 정렬
		for(int i=1; i<N+1; i++) {
			Collections.sort(graph.get(i));
			//Collections.reverse(graph.get(i)); : 이 코드 주석 해제하면 내림차순
		}
		
		// dfs 실행
		dfs(R);
		
		//출력
		for(int i=1; i<N+1; i++)
		{
			System.out.println(depth[i]);
		}
	}

	public static void dfs(int node) {
		visited[node] = true; // 방문하지 않았다면 조건을 뺌 -> visited[next]에서 하기 때문
		
		for(int i=0; i<graph.get(node).size(); i++) {
			int next = graph.get(node).get(i);
			
			if(!visited[next]) {
				 depth[next] = depth[node] + 1; // 자식 노드는 부모노드 + 1	
				dfs(next);
			}

		}
		
		
	}
	
}
