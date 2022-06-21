/**
 * https://www.acmicpc.net/problem/1000
 * 자바 문법 연습
 */

import java.util.Scanner;

public class baekjoon_1000_java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 자바에서 클래스를 인스턴스화 시킬때 앞에 new를 붙여줌
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(a + b);
        sc.close();
    }
}
