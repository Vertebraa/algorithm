import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1157
 * 문자열 문제 단어의 갯수 찾기
 * 문장을 입력받고 문장 안에 들어있는 단어의 갯수를 출력하는 문제
 * 문장안에 들어있는 공백의 갯수 + 1 이 단어의 갯수와 동일 하므로 공백을 찾는 방법으로 풀이함
 * 맨 앞과 맨 뒤에 공백이 올 수 있다는 조건이 있었으므로 처음과 마지막이 공백일 경우
 * blank 변수에서  - 1 해줌
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val sentence = sc.nextLine().toCharArray()

    var blank = 0

    for (i in sentence.indices) { // 문자열을 charArray화 시킨후 공백의 갯수를 모두 카운팅함
        if (sentence[i] == ' ') {
            blank++
        }
    }
    if (sentence[0] == ' ') { // 첫 글자가 공백이면 위에서 카운트한 blank 갯수 - 1
        blank -= 1
    }
    if (sentence.last() == ' ') { // 마지막 글자가 공백이면 위에서 카운트한 blank 갯수 - 1
        blank -= 1
    }
    println(blank + 1) // 공백의 갯수 +1 (= 단어의 갯수) 출력
}