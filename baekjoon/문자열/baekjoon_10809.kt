import java.io.*

/**
 * https://www.acmicpc.net/problem/10809
 * 문자열 문제 알파벳 찾기
 * 소문자로만 이루어진 단어가 입력되었을때, 각 알파벳이 첫번째 등장한 위치를 찾아라
 * 예를 들면 beakjoon의 경우 b가 첫번째, a가 두번째 e가 세번째 등장...
 * 출력 시 첫번째는 0 두번째는 1 세번째는 2... 이런식으로 출력
 * 다시 예를 보면 b는 1번쨰 위치 a는 0번째 위치
 * 만약 한번도 쓰이지 않은 알파벳은 -1로 표기
 *
 * 입력 예 baekjoon
 * 출력 예 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
*/

fun main(arg: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val inputText = br.readLine().toCharArray() // 입력받은 단어를 charArray화 시킴
    val result = IntArray(26) { -1 } // 결과Array는 최초엔 아무것도 입력되지 않았으므로 -1로 초기화

    for (i in 0 until inputText.size) { // 단어의 각 알파벳 마다 검사
        for (j in 0 until result.size) { // 알파벳이 몇번째에 대응 되는지 반복문으로 검사
            if (result[inputText[i].code - 97] != -1) { // 문제에서 '소문자로만'이라고 했기때문에 아스키 코드에서 97을 빼주면 알파벳 순서를 0부터 찾을 수 있음
                break // 동일한 알파벳이 연속될 때 최신화 되는걸 막기위해 초기값이 아니면 무시하고 탈출
            }
            result[inputText[i].code - 97] = i // 현재 알파벳이 몇번째에 입력됐는지
        }
    }
    result.forEach { print("$it ") } // 마지막으로 저장된 어레이(알파벳 사용 순서?) 출력
}


// 알파벳 순서를 콤푸타가 알아 먹는 방법은?
// 소문자만 입력한다고 했으니까 ascii 97~122 까지 숫자가에서 -96을 하면 알파벳 숫서가 됨
// baekjoon 입력 했을때 b가 inputText의 0번째에 있음
// inputText의 0번째 -97이 result의 n 번째와 같으면 result[inputText[i].code - 97] = i

// 중복을 어떻게 빼지?
// 0가 5번에도 있고 6번에도 있어서 6을 한방 더넣음
// 만약 값이 != -1일 경우는 무시한다 라는 방법이 있음
// if [result[inputArray[i].toInt - 97] != -1] break