package boj.p10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		int input;
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			input = Integer.parseInt(br.readLine());
			
			if(input == 0) 
				s.pop();
			else
				s.push(input);
		}
		
		int sum = 0;
		for(int i=0; i<s.size(); i++) {
			sum += s.get(i);
		}
		System.out.println(sum);
	}

}
