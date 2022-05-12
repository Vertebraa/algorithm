import java.util.*

/**
 * https://www.acmicpc.net/problem/1181
 * 정렬 문제 단어 정렬하기
 * N개의 단어를 입력 받은 후 단어의 길이를 우선하여 정렬하고
 * 길이가 같은 경우엔 알파벳 순서로 정렬하는 문제
 * 단, 중복된 단어가 있을 경우 한개만 출력한다
 * 중복을 제거하기 위해 list가 아닌 set을 사용해서 풀이함
 * 문자열의 경우 sort() 했을 때 알파벳 순서로 정렬되므로 sortedWith + comparedBy it.length , it으로 정렬함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt()
    val wordList = mutableSetOf<String>()

    for (i in 0 until testCase) {
        sc.next()?.let { wordList.add(it) } // 입력된 문자열이 null 이 아닌경우 let -> add 순서로 실행 set에 단어 입력
    }

    wordList.sortedWith(compareBy<String> { it.length } // 단어의 길이를 우선하여 sort 정렬
        .thenBy { it }) // 그 후에 길이가 같은경우 알파벳 순으로 정렬함
        .forEach{ println(it) }
}

// sorted는 set에 저장된 data를 기반으로 새로운 list를 만드는 형태이므로
// wordList를 직접 출력하는게 아니라 sorted된 list자체를 출력해야함
