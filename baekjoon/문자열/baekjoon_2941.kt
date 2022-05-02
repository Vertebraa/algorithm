import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2941
 * 문자열 문제 크로아티아 알파벳의 갯수
 * 문제에서 크로아티아 알파벳은 소문자와 '=', '-'로만 이루어 졌다고 주어짐
 * =와 -가 들어간 경우 카운트++
 * 남은 경우가 3개로 줄어듬 "dz=", "lj", "nj"
 * 조건식을 만들어서 해당경우만 추가로 카운트 해줌
 * 전체 문자열의 길이 - 카운트(크로아티아 알파벳은 2개 이상의 문자열로 이루어짐)로 실제 알파벳의 갯수를 구함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val inputWord = sc.next().toCharArray()

    var croatiaAlphabetCount = 0
    for (i in 0 until inputWord.size) {
        if (inputWord[i] == '=' || inputWord[i] == '-') {
            croatiaAlphabetCount++
        }
        if (i >= 2 && inputWord[i] == '=' && inputWord[i - 1] == 'z' && inputWord[i - 2] == 'd') {
            croatiaAlphabetCount++
        }
        if (i >= 1 && inputWord[i] == 'j' && inputWord[i - 1] == 'l') {
            croatiaAlphabetCount++
        }
        if (i >= 1 && inputWord[i] == 'j' && inputWord[i - 1] == 'n') {
            croatiaAlphabetCount++
        }

    }
    println(inputWord.size - croatiaAlphabetCount)
}


