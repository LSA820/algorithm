package boj.p18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 명령의 수
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			q.clear();
			
			switch(order) {
			case "push":
				q.offer(num);
				break;
			case "pop":
				q.poll();
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if(q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
				
			case "front":
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.peek());
				break;
			case "back":
				break;
			}
		}
	}

}
