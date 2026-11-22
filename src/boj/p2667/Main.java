package boj.p2667;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
 
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static List<Integer> complexes = new ArrayList<>(); // 아파트 단지 저장
	static int count; // 아파트 수
	static int[] dx = {+1, -1, 0, 0};
	static int[] dy = { 0,  0,+1,-1};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// 한줄 전체를 읽어서 공백 기준으로 토큰 분리
    	//StringTokenizer st = new StringTokenizer(br.readLine());
    		
    	// 첫 번째 토큰(첫 번째 공백 이전의 문자열)
    	//N = Integer.parseInt(st.nextToken());
    	  N = Integer.parseInt(br.readLine());

    	map = new int[N][N];
    	visited = new boolean[N][N];

    	// map 입력
    	for(int i =0; i<N; i++) {
    		String line = br.readLine();
    		for(int j=0; j<N; j++) {
    			map[i][j] = line.charAt(j) - '0';
    		}
    	}
    	
    	//map 인덱스 하나씩 방문
    	for(int i =0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if((map[i][j] == 1) && !visited[i][j]) { // 집(1)이고 방문하지 않은 인덱스라면
    				count = 0;
    				int size = dfs(i, j);
    				complexes.add(size);
    			}
    		}
    	}
    	//단지 수를 출력
    	System.out.println(complexes.size());
    	
        Collections.sort(complexes);
        for(int i=0; i<complexes.size(); i++) {
        	System.out.println(complexes.get(i));
        }
    }
    
    static int dfs(int row, int col) {
    	visited[row][col] = true;
    	count++;
    	
   	 	// 4방향으로 이동
	    for (int k = 0; k < 4; k++) {
	        int nextRow = row + dx[k];
	        int nextCol = col + dy[k];

	        // 1) 경계 검사
	        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
	            continue;
	        }
	        // 2) 집(1)이 아니면 지나치고
	        if (map[nextRow][nextCol] == 0) {
	            continue;
	        }
	        // 3) 이미 방문했으면 지나치고
	        if (visited[nextRow][nextCol]) {
	            continue;
	        }
	        // 4) 그 외의 경우에만 재귀 호출
	        dfs(nextRow, nextCol);
	    }
    	
	    return count;
    }
}
