/**
 * https://www.acmicpc.net/submit/11021
 * 자바 문법 연습
 */

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_11021_java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 1; i < testCase + 1; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write("Case #" + i + ": " + (a + b) + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
