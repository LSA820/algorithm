package boj.p28278;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 명령의 수
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int last = 0;  // 큐에 가장 마지막에 insert된 값을 기억하는 변수
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch(order) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				q.offer(num);
				last = num;
				break;
			case "pop":
				 if (q.isEmpty()) bw.write("-1\n");
                 else              bw.write(q.poll() + "\n");
				break;
			case "size":
				 bw.write(q.size() + "\n");
				break;
			case "empty":
				 bw.write((q.isEmpty() ? 1 : 0) + "\n");
				break;
				
			case "front":
				 if (q.isEmpty()) bw.write("-1\n");
                 else              bw.write(q.peek() + "\n");
				break;
			case "back":
				  if (q.isEmpty()) bw.write("-1\n");
                  else              bw.write(last + "\n");
		            break;
			}
		}
		 // 반복문이 끝나면 한 번에 flush
        bw.flush();
        // 프로그램 종료 시 close 해주거나, 생략해도 JVM 종료 시 자동으로 닫힙니다.
        bw.close();
	}

}
