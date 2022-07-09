/**
 * https://www.acmicpc.net/problem/15596
 * 자바 문법 연습
 */
public class baekjoon_15596_java {
}
class Test {
    long sum (int[] a) {
        long sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
