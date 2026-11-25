package boj.p2798;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 카드 개수
		int M = Integer.parseInt(st.nextToken()); // 카드 최대 합
		int[] arr = new int[N];

		// 카드 값 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int i;
		int j;
		int k;
		for (i=0; i < N - 2; i++) {
			for (j=i+1; j < N - 1; j++) {
				for (k=j+1; k < N; k++) {
					int sum = (arr[i] + arr[j] + arr[k]);
						if (sum <= M) max = Math.max(max, sum);
				}
			}
		}
		System.out.print(max);
	}
}
