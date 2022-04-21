import java.util.*

/**
 * https://www.acmicpc.net/problem/10818
 * 반복문을 사용한 N개의 정수중 최솟값과 최댓값 구하기
 * Array를 사용하지 않고 반복문 내에서 회차마다 입력한 정수를 읽도록함
 * min값과 max값을 항상 옳은 값으로 초기화 하기 위해 MAX VALUE와 MIN VALUE 사용
 */


fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    for (i in 0 until num) { // 반복 횟수를 제한
        val list = sc.nextInt() // 각 회차마다 정수를 입력 받음
        if (list < min) { // 해당 회차에 입력받은 정수가 min보다 작을때
            min = list // min 값을 해당 회차에 입력받은 정수로 초기화
        }
        if (list > max) { // 해당 회차에 입력받은 정수가 max보다 클 때
            max = list // max 값을 해당 회차에 입력받은 정수로 초기화
        }
    }
    print("$min $max") // 반복종료후 min과 max 출력
}

// num 숫자만큼 반복할꺼야
// 예를들어 num이 3일때
// 최초 반복문 i가 0일때
// 숫자를 받아온다 첫번째
// 최초 선언한 min(Int.MAX_VALUE)과 max(Int.MIN_VALUE)의 값과 첫번째 반복 후 나온 maxvalue랑 minvalue와 비교해서 저장한다
// i가 1일때
// 숫자를 받아온다 두번째
// i가 1일때 저장한 maxvalue랑 minvalue와 비교해서 저장한다
// i가 2일때 (마지막반복)
// 숫자를 받아온다 세번째
// i가 2일때 저장한 maxvalue랑 minvalue와 비교해서 저장한다
// 반복문 종료
// min, max 출력
// 코드 작성전에 어떻게 작성할 수 있을지 써본 것