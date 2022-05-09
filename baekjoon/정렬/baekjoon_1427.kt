import java.util.*

/**
 * https://www.acmicpc.net/problem/1427
 * 정렬 문제 소트 인사이드
 * 입력된 숫자로 이루어진 배열을 내림차순으로 정렬 출력하는 문제
 * 숫자가 개열이나 공백으로 나뉘지 않았으므로 charArray로 바꿔 각 index를 list화 시켜서 풀이함
 * sort(), reverse() 라는 코틀린에서 제공하는 정렬함수로 풀이 할 수 있지만 구현을 시도해봄
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val numbers = sc.next().toCharArray() // 입력받은 숫자들을 단일 숫자로 인식하지 않기 위해 charArray화 시킴
    val list = mutableListOf<Int>() // 위 array의 각 index를 list에 입력

    for (i in 0 until numbers.size) {
        list.add(numbers[i].code - 48) // char 타입을 곧장 int타입으로 바꾸면 ascii값이 나오므로 - 48
    }

    list.sort() // 오름차순으로 정렬

    for (i in 0 until numbers.size / 2) { // reverse()를 사용해도 되지만 반복문으로 직접 오름차순을 내림 차순으로 바꿔줌
        val temp = list[i]
        val swap = list[numbers.lastIndex - i]
        list[i] = swap // i 번째 index와 마지막 - i번째 index 교환
        list[numbers.lastIndex - i] = temp // 마지막 - i번째 index와 i번째 교환
    }// list.reverse()


    list.forEach { print(it) } // 리스트안에 저장된 값들 출력
}
