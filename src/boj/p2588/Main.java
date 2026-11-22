package boj.p2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		
		System.out.println(num1*(num2%10));
		System.out.println(num1*(num2%100/10));
		System.out.println(num1*(num2/100));
		System.out.println(num1*num2);
	}

}
