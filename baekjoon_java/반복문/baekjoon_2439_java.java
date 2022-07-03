/**
 * https://www.acmicpc.net/problem/2439
 * 자바 문법 연습
 */

import java.util.Scanner;

public class baekjoon_2439_java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 1; i <= testCase; i++) {
            for (int j = 1; j <= testCase - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
