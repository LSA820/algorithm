package boj.p27433;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = factorial(N);
		System.out.println(result);
	}
	
	static int factorial(int N) {
		if(N==0) {
			return 1; 
		}
		return N* factorial(N-1);
	}

}
