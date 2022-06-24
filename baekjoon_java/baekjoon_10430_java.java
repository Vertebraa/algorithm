/**
 * https://www.acmicpc.net/problem/10430
 * 자바 문법 연습
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10430_java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println((a + b) % c);
        System.out.println((a % c + b % c) % c);
        System.out.println((a * b) % c);
        System.out.println((a % c * b % c) % c);
    }
}
