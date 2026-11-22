package boj.p2606;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 노드 수
		sc.nextLine();
		int M = sc.nextInt(); // 간선 수
		sc.nextLine();
		int R = 1; // 바이러스에 걸린 노드(시작노드)
		
		graph = new ArrayList<>();
		visited = new boolean[N+1];
		
		//그래프 초기화
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList());
		}
		
		//그래프 입력
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			graph.get(u).add(v);
			graph.get(v).add(u); // 무방향 그래프
		}
		
		dfs(R);
		
		System.out.println(count);
	}
	
	static void dfs(int node) {
		visited[node] = true;
		
		for(int i=0; i<graph.get(node).size(); i++) {
			 int next = graph.get(node).get(i);
			 
			 if(!visited[next]) {
				 visited[next] = true;
				 count++;
				 dfs(next);
			 }
		}
	}

}
