package boj.p10871;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 개수
		int X = Integer.parseInt(st.nextToken()); // X 보다 작은 수
		
		int []arr = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			if(X>arr[i]) {
				System.out.printf(arr[i] + " ");
			}
		}
		
	}

}
