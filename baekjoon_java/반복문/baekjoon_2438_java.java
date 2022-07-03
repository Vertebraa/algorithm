/**
 * https://www.acmicpc.net/problem/2438
 * 자바 문법 연습
 */

import java.io.*;

public class baekjoon_2438_java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        for (int i = 1; i < a + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
