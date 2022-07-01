/**
 * https://www.acmicpc.net/problem/8393
 * 자바 문법 연습
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_8393_java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < a + 1; i++) {
            answer += i;
        }
        System.out.print(answer);
    }
}
