package boj.p9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            // VPS 함수 호출
            if (VPS(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // VPS 여부를 검사해서 true/false 반환
    public static boolean VPS(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // c == ')'
                if (stack.isEmpty()) {
                    return false;   // 매칭할 '(' 가 없으면 바로 false
                }
                stack.pop();
            }
        }
        // 모든 '('가 pop 되어야만 true
        return stack.isEmpty();
    }
}
