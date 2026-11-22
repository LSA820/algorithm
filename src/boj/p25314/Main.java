package boj.p25314;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int byteSize = Integer.parseInt(br.readLine());  
		
		int num = byteSize/4;
		
		
		for(int i=0; i<num; i++) {
			System.out.print("long ");
		}
		
		System.out.print("int");
	}

}
