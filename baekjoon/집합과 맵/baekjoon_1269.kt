import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1269
 * 집합과 맵 문제 대칭 차집합의 수를 구하는 문제
 * 대칭 차집합을 구하는 방법은 예를 들어 a = {1, 2, 4)이고, b = { 2, 3, 4, 5, 6 } 라고 할 때,
 * a - b = {1}, b - a = {3, 5, 6} 이다 이 두 집합의 합집합이 대칭 차집합이다
 * 두 집합에서 중복되는 원소를 제거하고 중복하지 않는 원소는 set에 add하여 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val set = hashSetOf<Int>() // 대칭 차집합이들어갈 set

    for (i in 0 until n) {
        val setA = sc.nextInt()
        set.add(setA) // 집합A를 우선 set에 add
    }

    for (i in 0 until m) {
        val setB = sc.nextInt()
        if (set.contains(setB)) { // 현재 set에 집합B의 원소와 중복되는 원소가 있다면
            set.remove(setB) // 해당 원소 제거
        } else {
            set.add(setB) // 중복원소가 없다면 set에 add
        }
    }
    print(set.size) // 현재 set의 size = 대칭 차집합의 원소갯수
}