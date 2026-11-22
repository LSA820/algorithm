package boj.p2798;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 카드 수
		int M = Integer.parseInt(st.nextToken()); // 최대 값

		int[] arr = new int[N];
		StringTokenizer cmd = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) { // 카드 각각의 숫자 입력 받기
			arr[i] = Integer.parseInt(cmd.nextToken());
		}
		
		int max = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					int tmp = arr[i] + arr[j] + arr[k];
					if(tmp <= M && tmp > max)
						max = tmp;
					}
				}
			}
		
		System.out.println(max);
	}

}
