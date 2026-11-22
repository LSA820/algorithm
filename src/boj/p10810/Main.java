package boj.p10810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];

		for(int i=0; i<M; i++) {
			StringTokenizer commmand = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(commmand.nextToken());
			int end = Integer.parseInt(commmand.nextToken());
			int ball = Integer.parseInt(commmand.nextToken());

			// start 를 직접 반복변수로 두지 말고 별도의 반복 볍수를 두자
			for(int j = start; j<=end; j++) {
				arr[j] = ball;
			}
		}
		
		// 1번부터 N번까지라는 지문에 따라 i<N+1 이 아니라 <=N 으로 둔
		for(int i=1; i<= N; i++) {
			System.out.print(arr[i] + " ");
		}
		
		/* 추천하는 출력형식
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.print(sb);
		*/
	}

}
