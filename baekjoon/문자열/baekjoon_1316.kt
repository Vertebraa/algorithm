import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1316
 * 문자열 문제 그룹단어 찾기
 * aaabbbccc 와 같이 각 알파벳이 연속한 형태로만 배열된 문자열을 그룹단어라고 함
 * aaabbbccca는 a가 마지막에 재등장 하면서 a가 연속되지 않으므로 그룹단어가 아님
 * length가 1인 경우는 무조건 그룹단어가 됨
 * 현재 i와 다음 알파벳이 동일한가를 먼저 확인하고
 * 동일하지 않다면 해당 알파벳이 이전에 등장했는가를 확인하는 방법으로 풀이함
 * 등장하지 않았다면 그룹단어++
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt()

    var groupWordCount = 0
    repeat(testCase) {
        val bunchOfAlphabet = sc.next()
        if (bunchOfAlphabet.length == 1) {
            groupWordCount++ // 길이가 1 = 무조건 그룹단어
        } else {
            val revealedAlphabet = mutableSetOf<Char>() // 문자열에 등장한 알파벳들을 set에 넣어서 구분함 (중복을 제거하므로)
            var cachedAlphabet = bunchOfAlphabet[0] // 현재 확인하고 있는 알파벳 (초기값은 첫번째 알파벳)

            var isGroupWord = true // 그룹단어 여부 초기값 true
            for (i in 1 until bunchOfAlphabet.length) { // 두번쨰 알파벳부터 확인함
                val currentAlphabet = bunchOfAlphabet[i] // 확인할 알파벳을 변수화
                if (cachedAlphabet != currentAlphabet) { // 알파벳이 연속되지 않는다면
                    revealedAlphabet.add(cachedAlphabet) // set에 확인하고 있는 알파벳을 추가함 (aab일 경우 a를 set에 add)
                    if (revealedAlphabet.contains(currentAlphabet)) { // set에 새롭게 확인하는 알파벳이 포함된 경우 (= 연속x 중복o 인경우)
                        isGroupWord = false // 그룹단어 여부는 false가 되고 카운트에 포함시키지 않음
                        break
                    } else {
                        cachedAlphabet = currentAlphabet // 중복되지 않았다면, 확인하는 알파벳을 연속이 끝난위치의 알파벳 (i)로 초기화
                    }
                }
            }
            if (isGroupWord) { // 그룹단어 여부가 true라면
                groupWordCount++ // 카운트 ++
            }
        }
    }
    println(groupWordCount) // 입력받은 문자열중 그룹단어가 몇개 인지 출력
}