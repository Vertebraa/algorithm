/**
 * https://www.acmicpc.net/problem/1001
 * 자바 문법 연습
 */

import java.util.Scanner;

public class baekjoon_1001_java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(a - b);
        sc.close();
    }
}
