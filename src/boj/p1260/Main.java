package boj.p1260;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Scanner;
	
	public class Main {
		static ArrayList<ArrayList<Integer>> graph;
		static boolean[] visitedDFS;
		static boolean[] visitedBFS;
		static int[] orderDFS;
		static int[] orderBFS;
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt(); // 노드 수
			int M = sc.nextInt(); // 간선 수
			int R = sc.nextInt(); // 시작노드
			
			graph = new ArrayList<>();
			visitedDFS = new boolean[N+1];
			visitedBFS = new boolean[N+1];
			orderDFS = new int[N+1];
			orderBFS = new int[N+1];
			Queue q = new LinkedList();
			
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
			
			// 그래프의 인접리스트를 정렬해줌 (그렇지 않으면 입력한 순서대로 방문)
			for (int i = 1; i <= N; i++) {
				Collections.sort(graph.get(i));
			}
				
			dfs(R);
			System.out.println();
			bfs(R, q);
	
		}
		
		static void dfs(int startNode) {
			visitedDFS[startNode] = true;
			System.out.print(startNode+ " ");
			
			for(int i=0; i<graph.get(startNode).size(); i++) {
				int nextNode = graph.get(startNode).get(i);
				
				if(!visitedDFS[nextNode]) {
					visitedDFS[nextNode] = true;
					
					dfs(nextNode);
				}
			}
		}
		
		static void bfs(int startNode, Queue q) {
			visitedBFS[startNode] = true; // 시작정점을 방문
			q.offer(startNode); // 시작 정점을 큐에 삽입
			
			while(!q.isEmpty()) { // q가 비어있지 않다면
				int current = (int) q.poll(); 
				System.out.print(current + " "); 
				
				for(int i=0; i<graph.get(current).size(); i++) {
					int adj = graph.get(current).get(i);
					
					if(!visitedBFS[adj]) {
						visitedBFS[adj] = true;
						q.offer(adj);
					}
				}
			}
		}
	
	}
