package boj.p15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int start = 1;
	static int[] result;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M]; // 하나의 수열만 저장
		dfs(0,1);
	}
	
	static void dfs(int depth, int start) {
		// depth 는 수열의 자릿수	
		if(depth == M) { 
			for(int i=0; i<M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;			
		}
		
		
		for(int i=start; i<N+1; i++) { // 1~N 까지 방문
			result[depth] = i;
			dfs(depth+1, i+1);
		}
	}

}
