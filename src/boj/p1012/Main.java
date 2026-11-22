package boj.p1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int  M;
	static int  N;
	static int  K;
	static int[] dx = {+1, -1, 0, 0};
	static int[] dy = {0, 0, +1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수
		
		// 테스트 케이스(밭 수)만큼 반복
		for(int h=0; h<T; h++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로 길이
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			K = Integer.parseInt(st.nextToken()); // 배추 위치 수
			
			// map을 0으로 채우기
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
			    Arrays.fill(map[i], 0);
			}
			
			visited = new boolean[N][M];
			count = 0;
			
			// 배추 위치 입력
			for(int i=0; i<K; i++) {
				  StringTokenizer st2 = new StringTokenizer(br.readLine());
				    int x = Integer.parseInt(st2.nextToken());
				    int y = Integer.parseInt(st2.nextToken());
				    map[y][x] = 1;  // or map[x][y] depending on M/N
			}
			
			// 인덱스 하나씩 순회하며 dfs
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if((map[i][j] == 1)&&(!visited[i][j])) { // 배추 심은 땅(1)이고, 방문x라면
						count++;
						dfs(i,j);
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	static void dfs(int row, int col) {
		visited[row][col] = true;
		
		// 4방향 검사
		for(int i=0; i<4; i++) {
			
			int nextRow = row + dx[i];
		    int nextCol = col + dy[i];
			
			// 인덱스 범위 벗어남
			if((nextRow<0) || (nextRow>=N) || (nextCol<0) || (nextCol>=M))
				continue;
			
			// map[nr][nc] == 0 이면
			if(map[nextRow][nextCol] == 0)
				continue;
			
			if (visited[nextRow][nextCol])
			    continue;   // 이미 갔던 곳이면 건너뛰고

			
			dfs(nextRow, nextCol);
		}
	}

}
