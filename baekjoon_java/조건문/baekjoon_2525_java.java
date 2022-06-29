/**
 * https://www.acmicpc.net/problem/2525
 * 자바 문법 연습
 * 조리 시간이 1시간 이상 걸리는 상황도 발생할 수 있으므로 시간 올림을 하는 조건이 추가될 수 있음 (번거로워 질 수 있다)
 * 현재 시간을 전부 분으로 바꾼 후 조리 후 시간을 시간으로 바꿔 표기하는 것을 풀이함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2525_java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        int totalMin = (h * 60) + m;
        totalMin += c;

        int hour = (totalMin / 60) % 24;
        int minute = totalMin % 60;
        System.out.print(hour + " " + minute);
    }
}
