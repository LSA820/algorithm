package boj.p15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] result;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		visited = new boolean[N+1];
		
		dfs(0);
	}
	
	static void dfs(int depth) {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int j=1; j<N+1; j++) {
			visited[depth] = true;
			dfs(depth+1);
			result[depth] = j;
			visited[depth] = false;
		}
	}

}
