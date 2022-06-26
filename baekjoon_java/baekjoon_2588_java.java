/**
 * https://www.acmicpc.net/problem/2588
 * 자바 문법 연습
 */

import java.util.Scanner;

public class baekjoon_2588_java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a * (b % 10));
        System.out.println(a * ((b / 10) % 10));
        System.out.println(a * (b / 100));
        System.out.println(a * b);
    }
}
