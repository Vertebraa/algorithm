/**
 * https://www.acmicpc.net/problem/4673
 * 자바 문법 연습
 *
 */

public class baekjoon_4673_java {
    public static void main(String[] args) {

        boolean[] checkArr = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int unSelfNumber = findUnSelfNumber(i);

            if (unSelfNumber < 10001) {
                checkArr[unSelfNumber] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!checkArr[i]) {
                System.out.println(i);
            }
        }
    }

    public static int findUnSelfNumber(int n) {
        int sum = n;

        while (n != 0) {
            sum = sum + (n % 10);
            n = n / 10;
        }
        return sum;
    }
}