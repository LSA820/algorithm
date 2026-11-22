package boj.bfs01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int count = 1;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] order;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 노드 수
		int M = sc.nextInt(); // 간선 수
		int R = sc.nextInt(); // 시작 정점
		
		Queue<Integer> q = new LinkedList<>(); // 큐는 인터페이스라서, 자료구조로 사용x 따라서 큐 자료구조로 사용할 수 있는 구현체를 골라서 생성
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		order = new int[N+1];
		
		// 그래프 초기화
		for(int i = 0; i<N+1; i++) {
			 graph.add(new ArrayList<>());
		}
		
		// 그래프 입력
		for(int i = 0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			graph.get(u).add(v);
			graph.get(v).add(u);
			
		}
		
		// 그래프의 인접리스트를 정렬해줌 (그렇지 않으면 입력한 순서대로 방문)
		for (int i = 1; i <= N; i++) {
				    Collections.sort(graph.get(i));
		}
		
		bfs(R, q);
		
		for (int i = 1; i <= N; i++) {
		    System.out.println(order[i]);
		}

	}
	
	static void bfs(int startNode, Queue<Integer> q) {
		visited[startNode] = true;       // 시작 정점을 제일 먼저 방문 처리
		order[startNode]   = count++;    // 시작 정점의 방문 순서를 1로 기록하고, count를 2로 증가
		q.offer(startNode);

		while(!q.isEmpty()) {
			int current = q.poll(); // startNode를 큐에서 꺼냄
			for(int i=0; i<graph.get(current).size(); i++) { // start 노드의 인접 정점들 호출
				int adj = graph.get(current).get(i); // 인접 정점을 adj에 저장
				if (!visited[adj]) { // 방문하지 않은 정점이라면
				    visited[adj] = true; 
				    order[adj]   = count++;
				    q.offer(adj);
				}
			}
		}
	}

}
