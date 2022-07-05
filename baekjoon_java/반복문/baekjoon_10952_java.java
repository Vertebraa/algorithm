/**
 * https://www.acmicpc.net/problem/10952
 * 자바 문법 연습
 */

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_10952_java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (num1 == 0 && num2 == 0) {
                break;
            } else {
                bw.write((num1 + num2) + "\n");
            }
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
