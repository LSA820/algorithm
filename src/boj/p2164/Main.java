package boj.p2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 카드의 수
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<= N; i++) {
			q.offer(i);
		}
		
		while(q.size() > 1) {
			q.poll(); // 맨 위에 버림
			q.offer(q.poll()); // 그 다음 건 빼서 맨 뒤에 삽입
		}
		
		System.out.println(q.peek());
	}

}