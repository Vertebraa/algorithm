/**
 * https://www.acmicpc.net/problem/2577
 * 자바 문법 연습
 * 코틀린과 toString() 사용 방법이 조금 달라서 사용 방법을 검색해서 풀이함
 */

import java.util.Scanner;

public class baekjoon_2577_java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        String str = Integer.toString(a * b * c);

        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if ((str.charAt(j) - 48) == i) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
