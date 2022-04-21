import java.util.*

/**
 * https://www.acmicpc.net/problem/2562
 * 1차워 배열문제 (2)에서 풀이한 방법과 동일
 * Scanner와 Println사용
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)

    val array = IntArray(9) // Array의 size 지정

    for (i in 0 until 9) {
        array[i] = sc.nextInt() // Array의 각 index마다 자연수를 set
    }
    var max = 0 // 최초 max 변수값 지정 (입력이 자연수 이므로 0을 넣었을때 항상 옳은 값으로 초기화)
    var count = 0 // 최초 count 변수값 지정 (순서는 1번부터 시작이므로 0을 넣었을때 항상 옳은 값으로 초기화)

    for (i in 0 until 9) { // 반복횟수를 제한
        if (max < array[i]) {
            max = array[i] // max의 값이 해당 반복회차에 입력된 자연수보다 클 경우 해당값으로 max를 초기화
            count = i + 1 // 위의 조건 충족시 count를 해당 회차의 i값 + 1 후 count 변수값 초기화
        }
    }
    println(max) // 최종 max값 출력
    println(count) // 최종 count값 출력
}

// 자연수를 입력 받을수 있는 array를 만든다
// array의 사이즈는 문제에서 제시한 대로 9개로 지정
// array내에 index마다 자연수를 입력함
// max와 count는 mutable 0으로 초기화 (자연수를 입력 받았을때 항상 옳은 값이 기록되기 위함, 실행전 index 번호가 없기 때문)
// 첫번째 반복을 실행 할때 max보다 array의 현재 index값이 큰경우 해당 index값으로 max를 초기화 후 저장
// 위의 조건이 성립할때 해당 index 번호에 1을 더해준 후 저장 (index + 1 = n번째 숫자 ex)index0 = 1번째 숫자)
// 지정한 반복 횟수 만큼 반복문 실행
// 마지막에 저장된 max값과 index값을 개행하여 출력