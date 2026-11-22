package boj.p25304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine()); // 총 금액
		int cnt = Integer.parseInt(br.readLine()); // 물건 종류 수 (반복 수)
		int sum = 0;
		
		for(int i=0; i<cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int a = Integer.parseInt(st.nextToken()); // 가격
			int b = Integer.parseInt(st.nextToken()); // 개수
			
			sum = sum + (a*b);
		}
		
		if(sum == total)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
