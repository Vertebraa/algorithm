/**
 * https://www.acmicpc.net/problem/10871
 * 자바 문법 연습
 */

import java.util.Scanner;

public class beakjoon_10871_java {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int standard = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int num = sc.nextInt();

            if (num < standard) {
                System.out.print(num + " ");
            }
        }
    }
}
