/**
 * https://www.acmicpc.net/problem/14681
 * 자바 문법 연습
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_14681_java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if (x > 0 && y > 0) {
            System.out.print(1);
        } else if (x < 0 && y > 0) {
            System.out.print(2);
        } else if (x < 0 && y < 0) {
            System.out.print(3);
        } else {
            System.out.print(4);
        }
    }
}
