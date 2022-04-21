import java.util.*

/**
 * https://www.acmicpc.net/problem/10818
 * 반복문을 사용한 N개의 정수중 최솟값과 최댓값 구하기
 * Int로 이루어진 Array를 만들어 풀이함
 * min값과 max값을 항상 옳은 값으로 초기화 하기 위해 MAX VALUE와 MIN VALUE 사용
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)

    val num = sc.nextInt()
    val array = IntArray(num) // 입력한 값과 같은 Size의 Array를 만듬

    for (i in 0 until num) { // 반복문의 반복 횟수 제한
        array[i] = sc.nextInt() // Array의 각 index를 입력한 정수로 set함
    }
    var min = Int.MAX_VALUE // 최초 min의 값, Int값중 가장 큰 값을 선언해서 무조건 Array내의 첫번째 index를 받을 수 있게 함
    var max = Int.MIN_VALUE // 최초 max의 값, Int값중 가장 작은 값을 선언해서 무조건 Array내의 첫번째 index를 받을 수 있게 함

    for (i in 0 until num) {
        if (array[i] < min) { // 해당 반복 회차의 array의 index가 min(Int 타입의 최대정수)보다 작을 때
            min = array[i] // min의 값은 array의 index 값으로 초기화됨
        }
        if (array[i] > max) { // 해당 반복 회차의 array의 index가 max(Int 타입의 최소정수)보다 클 때
            max = array[i] // max 값은 array의 index 값으로 초기화됨

        }
    }
    print("$min $max") // 반복종료후 min과 max 출력
}