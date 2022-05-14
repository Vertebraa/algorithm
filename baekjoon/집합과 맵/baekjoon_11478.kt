import java.util.*

/**
 * https://www.acmicpc.net/problem/11478
 * 집합과 맵 문제 서로 다른 부분 문자열의 개수
 * 문자열이 주어졌을때 해당 문자열의 서로 다른 부분 문자열을 개수를 구하는 문제
 * 예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고
 * 중복되는 a, b, ab, 를 제거한 12를 출력하면 된다
 * 중복이 없어야 하므로 hashSet을 사용하고 한자리 부터 문자열의 size 자리까지 부분 집합을 set해서 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val string = sc.next()
    val set = hashSetOf<String>()

    for (pickCount in 1..string.length) { // 한자리 부터 문자열의 size자리까지
        for (i in 0..string.length - pickCount) {
            set.add(string.substring(i, i + pickCount)) // pickCount가 1일때 0번 째부터 1의 앞자리 까지 (=한 자리)
        }
    }
    println(set.size)
}