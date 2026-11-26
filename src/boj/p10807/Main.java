package boj.p10807;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 정수 개수
        String line = br.readLine(); // 수열 저장
        int v = Integer.parseInt(br.readLine()); // 찾을 정수
        int cnt = 0;
        String[] sarr = line.split(" ");

        for (int i = 0; i < sarr.length; i++) {
            if ((Integer.parseInt(sarr[i]) == v)){
                cnt++;
            }

        }
        System.out.print(cnt);
    }
}
