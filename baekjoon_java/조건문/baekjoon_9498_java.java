/**
 * https://www.acmicpc.net/problem/9498
 * 자바 문법 연습
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9498_java {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        if (90 <= a && a <= 100) {
            System.out.println("A");
        } else if (80 <= a && a <= 89) {
            System.out.println("B");
        } else if (70 <= a && a <= 79) {
            System.out.println("C");
        } else if (60 <= a && a <= 69){
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
