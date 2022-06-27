/**
 * https://www.acmicpc.net/problem/2884
 * 자바 문법 연습
 * 자바는 코틀린과 다르게 변수의 variable 타입이 var이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2884_java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m < 45) {
            h--;
            m += 15; // m = 60 - (45 - m)
            if (h < 0) { // java는 kotlin과 다르게 변수가 var이 기본이므로 위에서 -- 했기 때문에 0보다 작은 상태여야한다. 아니면 h == -1로 해도됨
                h = 23;
            }
            System.out.print(h + " " + m);
        } else {
            System.out.print(h + " " + (m - 45));
        }
    }
}
