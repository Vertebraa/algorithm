import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/14425
 * 집합과 맵 문제 문자열 집합과 일치하는 문자열 갯수 찾기
 * N개의 문자열을 입력 받고(=집합 S) 이어지는 M개의 문자열 중에 집합 S를 구성하는 문자열과 일치하는 문자열의 갯수를 출력하는 문제
 * hashSet과 contains 함수를 사용해서 풀이함
 * 단순 반복문을 사용해서 풀이하면 결과는 동일 하지만 시간초과에 걸림
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val set = hashSetOf<String>() // 집합 S에는 동일한 문자열이 오는 경우가 없음, 시간복잡도를 O(n + m)을 만들기 위해 사용함

    for (i in 0 until n) {
        set.add(sc.next()) // 입력받은 문자열을 집합 S에 저장함
    }

    var matchSet = 0
    for (i in 0 until m) {
        if (set.contains(sc.next().toString())) { // 이후 m 개의 문자열을 돌면서 집합(hashSet)에 일치하는 문자가 있으면 ++
            matchSet++
        }
    }
    println(matchSet)
}