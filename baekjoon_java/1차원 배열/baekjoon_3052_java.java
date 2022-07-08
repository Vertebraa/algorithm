/**
 * https://www.acmicpc.net/problem/3052
 * 자바 문법 연습
 */

import java.util.Scanner;

public class baekjoon_3052_java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            arr[i] = a % 42;
        }
        int count = 0;

        for (int i = 0; i < 10; i++) {
            int match = 0;
            for (int j = i + 1; j < 10; j++) {
                if (arr[i] == arr[j]) {
                    match++;
                    break;
                }
            }
            if (match == 0) {
                count++;
            }
        }
        System.out.print(count);
    }
}
