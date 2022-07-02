/**
 * https://www.acmicpc.net/problem/10950
 * 자바 문법 연습
 */

import java.util.Scanner;

public class baekjoon_10950_java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}
