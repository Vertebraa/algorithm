/**
 * https://www.acmicpc.net/problem/2741
 * 자바 문법 연습
 */

import java.io.*;

public class baekjoon_2741_java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        for (int i = 0; i < a; i ++) {
            bw.write((i + 1) + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
