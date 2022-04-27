import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1065
 * 함수를 사용해서 한수를 찾기
 * 한수 = 각 자리의 수가 등차수열을 이루는 수 ex) 123 456 789 246 369..
 * 1부터 입력된 숫자 사이에 있는 모든 한수의 갯수를 구하는 문제
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()

    var count = 0
    for (i in 1..num) { // 1부터 입력된 수 까지 반복
        if (isHanSoo(i)) { // 함수에 return된 값이 true이면
            count++ // 카운트
        }
    }
    println(count) // 마지막에 저장된 count 갯수 출력
}

private fun isHanSoo(n: Int): Boolean { // 입력된 숫자가 한수인지 아닌지를 찾아야 하므로 타입은 Boolean
    val number = n.toString().toCharArray() // 입력된 숫자를 CharArray화 한 것
    if (number.size <= 2) { // 1~2자릿수는 모두 한수 이므로
        return true // 자릿수 (=인덱스의 사이즈)가 2이하면 true
    } else { // 3자릿수 이상일때
        val fixedGap = number[1] - number[0] // 첫 숫자와 두 번째 숫자의 차이를 먼저 구함
        for (i in 1..number.size - 2) { // 다음 숫자들 간의 gap을 구하는데 outOfBound가 날 수 있으니 안전한 회차까지 제한
            if (number[i+1] - number[i] != fixedGap) { // 두 번째 숫자와 다음 숫자의 차이가 fixedGap과 다를 경우
                return false // 한수가 아님 return
            }
        }
        return true
    }
}

// 한수 = 각 자리의 수가 등차수열을 이루는 수 ex) 123 456 789 246 369..
// 숫자 N이 주어짐 1 <= N =< 1000
// 한수의 갯수를 구하라

//
// i in 1..1000
// 이걸 쪼개 인덱스로 456이면 4 5 6으로
// 예를 들어 index[i+1]-index[i] == index[i+2]-index[i+1] = 한수
// 그런데 위의 코드를 그대로 작성하면 out of bound exception이 날수 있으니 다른 방법으로 해결해야함
// 예제를 확인해보면 1자리~ 2자리 숫자는 모두 한수로 취급한다는걸 알 수 있음
// if i = 한수면 count++
// count 출력