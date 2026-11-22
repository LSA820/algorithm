package boj.p2439;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int h = Integer.parseInt(br.readLine()); //5
		int j; 
		int l;
		for(int i=1; i<h+1; i++) {
			for(j=h-i; j>0; j--) {
				System.out.printf(" ");
			}
			for(l=0; l<i; l++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}

}
