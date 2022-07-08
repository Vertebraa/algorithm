/**
 * https://www.acmicpc.net/problem/2562
 * 자바 문법 연습
 */

import java.util.Scanner;

public class baekjoon_2562_java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int max = 0;
        int count = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count = i + 1;
            }
        }
        System.out.print(max + "\n" + count);
    }
}
