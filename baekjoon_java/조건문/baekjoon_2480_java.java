/**
 * https://www.acmicpc.net/problem/2480
 * 자바 문법 연습
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2480_java {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int prize = 0;
            if (a == b && b == c) {
                prize = 10000 + a * 1000;
            } else if (a == b || a == c) {
                prize = 1000 + a * 100;
            } else if (b == c) { // 숫자 두개만 같은 경우 같은 수 * 100을 상금에 더해야 하는데 or 연산자를 사용한 조건문 한개에선 모든 경우를 세기 어려움
                prize = 1000 + b * 100;
            } else {
                int max = a;
                if (b > max) {
                    max = b;
                }
                if (c > max) {
                    max = c;
                }
                prize = max * 100;
            }
            System.out.print(prize);
    }
}

