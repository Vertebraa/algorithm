import java.util.*

/**
 * https://www.acmicpc.net/problem/1110
 * 반복문을 사용한 더하기 사이클 구하기
 * mutable 변수값을 반복문 외부에 지정해야 한다는 것을 헷갈려서 애먹었었음
 * 문제에서 제시하는 10의 자리숫자와 1의 자리 숫자를 구할때 /와 %라는 명확한 기재가 있는걸 인지해야함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    var n = sc.nextInt()

    var ten = 0
    var one = 0
    var sum = 0
    var cycle = 0
    val last = n // 각각 변수들의 초기값 설정

    while (true) {
        ten = n / 10 // 각 반복 실행의 두자릿수의 10의 자리를 저장
        one = n % 10 // 각 반복 실행의 두자릿수의 1의 자리를 저장
        sum = (ten + one) % 10 // 10의 자릿수와 1의 자릿수를 각각의 숫자로 보고 더한후 1의 자리 숫자 저장
        n = (one * 10) + sum // 위까지 계산후 one값을 10의 자릿수로, sum을 1의 자릿수로 한 두자릿수를 저장
        cycle++ // 이후 사이클횟수에 1을 더함
        if (last == n) break // 맨처음 입력한 n과 사이클 종료후 저장된 값이 같을경우 종료
    }
    println(cycle) // 총 사이클 횟수를 출력
}
