package boj.dfs02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int count = 1;
	static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
	static int[] order;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		int N = Integer.parseInt(input[0]); // 노드 개수
		int M = Integer.parseInt(input[1]); // 간선
		int R = Integer.parseInt(input[2]); // 시작 노드
		
		visited = new boolean[N + 1];
        order   = new int    [N + 1];
        graph   = new ArrayList<>(); // ArrayList<ArrayList<Integer>>() 라고 하지 않아도 제네릭 타입이기에 컴파일러가 알아서 추론함
		
        // 그래프 초기화
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 입력
		for(int i = 0; i<M; i++) {
		    int u = sc.nextInt();  // 공백·줄바꿈 무시하고 바로 다음 정수 읽음
		    int v = sc.nextInt();
		    
		    graph.get(u).add(v);
		    graph.get(v).add(u);
		}
		
		// 그래프의 인접리스트를 정렬해줌 (그렇지 않으면 입력한 순서대로 방문)
		for (int i = 1; i <= N; i++) {
		    Collections.sort(graph.get(i));
		    Collections.reverse(graph.get(i)); //: 내림차순 정렬 시 오름차 한 뒤 리버스로 내림차순으로 만듦
		}

		

		dfs(R); //시작노드
		
		for (int i = 1; i <= N; i++) {
		    System.out.println(order[i]);
		}
	}

	
	public static void dfs(int node) {
		if(!visited[node]) { // 방문하지 않은 노드라면
			visited[node] = true;
			order[node] = count++; // 방문순서 대입 후 증가
		}
		
		for(int i = 0; i<graph.get(node).size(); i++) {
			int next = graph.get(node).get(i);
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
}
