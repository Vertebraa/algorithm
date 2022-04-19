import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2480
 * 조건문을 사용해 주사위 값별 상금 구하기
 * 최대값을 구하기 위해 maxOf를 사용함
 * maxOf 함수에는 정수를 두개만 넣을 수 있어서 중첩해서 사용함
 */
fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val num1 = sc.nextInt() // 주사위 눈금 1번 입력
    val num2 = sc.nextInt() // 주사위 눈금 2번 입력
    val num3 = sc.nextInt() // 주사위 눈금 3번 입력

    if ((num1 == num2) && (num2 == num3)) { // 모든 눈금이 같은 경우
        println(10000 + (num1 * 1000))
    } else if ((num1 == num2) || (num1 == num3)) { // 세개중 두개의 눈금이 같은 경우
        println(1000 + (num1 * 100))
    } else if ((num2 == num3)) { // 세개중 두개의 눈금이 같은 경우 or(||) 연산자를 중복하면 잘못된 값이 나오기 때문에 분리함
        println(1000 + (num2 * 100))
    } else { // 그 이외의 모든 눈금이 다를 경우
        println(maxOf(num1,(maxOf(num2,num3))) * 100)
    }
}