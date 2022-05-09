import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2751
 * 정렬 문제 입력받은 수를 오름차순으로 정리하는 문제
 * 시간복잡도가 O(n²)가 나오지 않게 연산시간을 줄여야 하는 문제다
 * sort()가 quick정렬이긴 하지만 최악의 경우 O(n²)가 나올 수 있기 떄문에
 * StringBuilder를 사용해 조금이라도 시간을 줄여서 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val list = mutableListOf<Int>() // 입력한 수가 들어갈 리스트를 만들어줌

    for (i in 0 until n) {
       list.add(sc.nextInt()) // 입력 받은 정수들을 리스트에 저장
    }
    list.sort() // 오름차순으로 정렬

    val sb = StringBuilder()
    for (i in 0 until n) {
        sb.append(list[i]) // StringBuilder에 정렬된 수를 저장함
        sb.append("\n")
    }

   println(sb.toString()) // StringBuilder에 저장된 값을 출력
}