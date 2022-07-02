/**
 * https://www.acmicpc.net/problem/15552
 * 자바 문법 연습
 */

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_15552_java {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write((a + b) + "\n");
        }
        br.close();

        bw.flush();
        bw.close();

    }
}
