import java.util.*

/**
 * https://www.acmicpc.net/problem/3052
 * 1차원 배열문제 10개의 자연수를 각각 42로 나누고 나머지값의 서로 다른 값의 갯수를 출력
 * Hashset이나 set와 같은 중복하지 않은 원소만 저장하는 클래스를 사용 하는 방법이 있음
 * 하지만 아직 위의 클래스를 사용하는 방법을 모르기 때문에 배열과 for if 구문만을 사용해서 풀이함
 * Hashset으로 나눗셈한 값을 .add해주고 Hashset의 size를 출력하는 코드가 훨씬 간결해 보임
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)

    val array = IntArray(10) // 입력한 자연수를 42로 나눈 값이 들어갈 Array를 만듬
    var missMatch = 0 // 서로 다른 자연수의 갯수 최초에 0으로 초기화

    for (i in array.indices) {
        array[i] = sc.nextInt() % 42 // 입력값을 각각 42로 나누고 나머지를 array의 각 index에 할당함
    }
    for (i in array.indices) {
        var match = 0 // 나머지의 값이 중복하는 경우 초기값은 0
        for (j in i+1 until array.size) {
            if (array[i] == array[j]) { // 나머지의 현재 index의 숫자와 그 다음 index의 숫자가 같은경우
                match++ // match + 1
            }
            }
        if (match == 0) { // 만약 중복되는 경우 가 없을 경우
            missMatch++
        }
    }
    println(missMatch)
}


// 정수 총 10개를 입력받음
// 그 후 10개의 정수를 42로 각자 나눔
// 42로 나눈 나머지 값을 저장
// 각각의 인덱스에서 서로 같은 값과 다른값을 구분해서 카운트를 올리면 될것 같음 ?
// 0번 index와 1번부터 9번 index의 값을 각각 비교함
// 같은 값이 있다면 0번 index와 n번 index가 같다는 거니까 match에 + 1
// 만약 n번 index와 나머지 index 값이 다르다면 (match가 0일때) missMatch에 + 1
// 반복 종료 후 저장된 missMatch의 값 출력
//
// 예를 들어
// 1 1 1 1 1 1 1 1 1 1 을 입력한 경우
// 42로 나누면 나머지가 1 1 1 1 1 1 1 1 1 1 1 1
// index(0..9)와 index((0 + 1)..9)의 값이 같으므로 모든 케이스에 match + 1
// 서로 다른 숫자는 0 (match가 0인 경우가 발생하지 않음 = missMatch에 + 1이 되는 경우 발생하지 않음)
//
// 1 2 3 4 5 6 7 8 9 10 을 입력한 경우
// 나머지가 1 2 3 4 5 6 7 8 9 10 이므로
// index(0..9)와 index((0 + 1)..9)의 값이 모두 다르므로 모든 케이스에서 match = 0
// 서로다른 숫자는 10 (모든 케이스에서 match가 0이므로 missMatch에 + 1 * n(반복 횟수만큼))
