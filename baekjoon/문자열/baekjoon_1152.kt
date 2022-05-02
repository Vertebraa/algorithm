
/**
 * https://www.acmicpc.net/problem/1157
 * 문자열 문제 단어의 갯수 찾기
 * 문장을 입력받고 문장 안에 들어있는 단어의 갯수를 출력하는 문제를 다른 방법으로 풀이함
 * .trim()을 사용해 앞뒤 공백을 제거한 후 공백을 기준으로 나눠서 array에 넣음
 * array의 size를 출력해서 단어의 갯수를 찾음
 */

fun main(arg: Array<String>) {
    val sentence = readLine()?.trim()?.split(" ")?.filter { it.isNotEmpty() }
    // 문장을 앞,뒤 공백을 제거하고 공백을 기준으로 나눔
    val splitSentence = arrayOf(sentence) // 위에서 나눈 각 단어들을 어레이에 담아줌


    splitSentence.forEach {
        if (it != null) {
            println(it.size.toString()) // 사이즈 (=단어의 갯수) 출력
        }
    }
}
