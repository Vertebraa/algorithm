import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/11654
 * 문자열 문제 아스키 코드를 출력 시키는 문제
 * 알파벳 대소문자 & 숫자를 아스키 코드로 바꾸는 방법을 알게됨
 * Char 타입의 문자를 toInt로 바꿔주면 아스키 코드의 값이 나옴
 * 컴퓨터 언어는 숫자로 구성되어 있으므로 문자역시 숫자로 기억함, 각 문자에 대응되는 숫자? 번호? 가 아스키 코드
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val character = sc.next().toCharArray() // 숫자를 입력받아서 char 타입으로 바꿔줌

        character.forEach { println(it.code) } // 각 index를 ascii코드로 출력
}

//
//fun main(arg: Array<String>) {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val character = br.read()
//
//    println(character)
//}

// BuffedReader를 사용하면 char타입으로 받으므로 .read()로 Int타입으로 문자를 받게 만듬
// 그대로 출력하면 ascii 코드가 출력됨