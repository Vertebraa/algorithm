/**
 * https://www.acmicpc.net/problem/2739
 * 자바 문법 연습
 */

import java.util.Scanner;

public class baekjoon_2739_java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for (int i = 1; i < 10; i++) {
            System.out.println(a + " * " + i + " = " + a * i);
        }
    }
}
