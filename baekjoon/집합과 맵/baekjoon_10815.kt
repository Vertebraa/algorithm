import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/10815
 * 집합과 맵 문제 일치하는 숫자 카드 찾기
 * -10000000 ~ 10000000 사이의 숫자가 적혀진 N개의 카드를 상근이가 가지고 있다 (중복된 숫자는 없다)
 * -10000000 ~ 10000000 사이의 숫자가 적혀진 M개의 카드를 새로 가져 왔을때
 * 새로 가져온 M개의 카드에 적혀있는 숫자가 상근이의 카드와 일치하면 1, 일치하지 않으면 0을 출력하는 문제 (출력순서는 카드 순서와 동일)
 * hashSet과 contains 함수를 사용하여 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val sangguen = hashSetOf<Int>()
    // 중복되는 숫자가 없다는 전제가 있어서 hashSet을 사용
    // 배열 구조 사용시 대조시 시간 복잡도가 O(n * m)이 되어서 값을 알고 있는 경우 직접 접근이 가능한 hashSet이 효과적임

    for (i in 0 until n) {
        sangguen.add(sc.nextInt()) // hashSet에 n개의 카드에 적힌 숫자를 add
    }

    val m = sc.nextInt()
    val sb = StringBuilder()
    for (i in 0 until  m) {
        if (sangguen.contains(sc.nextInt())) { // m개의 카드중 상근이의 카드에 동일한 값이 contains(key로써 접근) 되어있다면
            sb.append(1) // 1을 StringBulider에 추가
        } else {
            sb.append(0) // 없으면 0을 추가
        }
        sb.append(' ')
    }
    print(sb.toString().trim())
}