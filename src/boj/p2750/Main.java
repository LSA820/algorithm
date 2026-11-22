package boj.p2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			arr.add(input);
		}
		
		Collections.sort(arr);
		
		for(int x : arr) {
			System.out.println(x);
		}
	}

}
