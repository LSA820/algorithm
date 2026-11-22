package boj.p2131;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 분해합
	
		
		// N 분해합 = M 자연수 = 생성자 + M의 각 자릿수
		int sum;
		
		// 자릿 수 합 구하기
		for(int i=1; i<=N; i++) {
			int divTmp = i;
			sum=0;
			
			while(divTmp != 0) {
				int tmp = divTmp%10;
				sum += tmp;
				divTmp /= 10;
			}

			if((sum + i) == N) {
				System.out.println(i);
				
				break;
			}
			
		}

	}

}
