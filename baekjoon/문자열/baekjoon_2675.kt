import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2675
 * 문자열 문제 문자열 반복시키기
 * repeat 횟수만큼 입력받은 알파벳을 각각 반복하여 출력하는 문제
 * 예를 들어 2 ABC를 입력하면 AAABBBCCC 로 출력되어야 함
 * 입력받은 알파벳조합을 각각 char 타입으로 분리한 후
 * (반복횟수 * 입력받은 문자조합의 size)크기의 Array에 순차적으로 set 시켜서 풀이함
 */

fun main(arg: Array<String>) {

    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt()

    for (i in 0 until testCase) {

        val repeatCount = sc.nextInt() // 반복 횟수를 입력
        val alphabets = sc.next() // 알파벳 조합을 입력
        val answerArray = CharArray(repeatCount * alphabets.length) // 알파벳을 순차적으로 넣기위한 charArray
        var answerArrayIndex = 0

        for (element in alphabets) { // 입력한 알파벳 조합의 element(알파벳 string의 element = char)를 순서대로 반복
            repeat(repeatCount) { // 반복 횟수만큼 반복문 실행
                answerArray[answerArrayIndex] = element // answerArray의 초기값 0번 index에 alphabets의 element를 set
                answerArrayIndex++ //인덱스 번호를 1번 올려줌
            }
        }
        println(answerArray) // 마지막에 저장된 Array의 값들 출력
    }
}
