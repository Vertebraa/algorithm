/**
 * https://www.acmicpc.net/problem/10818
 * 자바 문법 연습
 * 배열 문제이지만, 배열을 사용하는 것보다 입력받자마자
 * 각 수를 직접 비교하는것이 시간복잡도를 고려했을때 더 효율 적이라고 생각됨
 * 배열로 풀이할 경우 입력된 수를 모두 배열에 넣어주고
 * Array.sort(배열)로 정렬한 후에 가장 앞과 가장 마지막 수를 출력하는 것으로 풀이 가능함
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10818_java {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int maxVal = -1000001;
        int minVal = 1000001;

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if (num > maxVal) {
                maxVal = num;
            }
            if (num < minVal) {
                minVal = num;
            }
        }
        System.out.print(minVal + " " + maxVal);
    }
}
