package boj.p2178;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int N; // row
	static int M; // col
	static int[][] dist; // 최단 거리 저장할 배열
	static int[] dx = {+1, -1, 0, 0};
	static int[] dy = {0, 0, +1, -1};
	static Queue<Point> q= new LinkedList<>(); // point 타입으로 좌표 받음
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];
	
		//map 입력 받기
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				int s = line.charAt(j) - '0';
				map[i][j] = s;
			}
		}
		
		bfs(); // 시작 좌표를 넘겨줌
		
		System.out.println(dist[N-1][M-1]);
	}
	
	 static void bfs() {
		dist[0][0] = 1;             // 시작 칸도 포함
		visited[0][0] = true;
		q.offer(new Point(0,0));
		
		while(!q.isEmpty()) { // 큐가 비지 않았다면

			// 노드를 꺼내고, 인접 노드들을 방문처리
			Point p = q.poll();
			
			for(int i =0; i<4;i++) {
				int nr = p.x + dx[i];
				int nc = p.y + dy[i];
				
				// 경계값 검사
				if(nr<0 || nr>=N || nc<0 || nc >=M)
					continue;
				
				// 1(길)과 0(벽) 검사... "또는" 조건 연산자
				if (map[nr][nc] == 0 || visited[nr][nc]) 
				    continue;
				
				//인접 노드라면
				 visited[nr][nc] = true; // 방문처리
			     dist[nr][nc] = dist[p.x][p.y] + 1; // dist에 삽입
			     q.offer(new Point(nr, nc)); // 큐에 삽입
			}
		}
	}

}
