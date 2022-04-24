import java.util.*

/**
 * https://www.acmicpc.net/problem/8958
 * 1차원 배열문제 OX퀴즈
 * O와X로 이루어진 문자열을 입력받고 최종 점수를 출력하는 문제
 * 점수 산정 방식은 O는 1점 X는 0점 (O가 연속된 경우 연속된 O의 갯수만큼 점수를 얻음)
 * 예를 들어 ooxxooxxoo의 경우 각각 1 2 0 0 1 2 0 0 1 2점
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt()


    for (i in 0 until testCase) {
        val ox = sc.next() // OX를 String 타입으로 입력 받음
        var count = 1
        var score = 0
        ox.forEach { // OX들을 각각 한개 씩 반복하며 확인
            if (it == 'O') { // 현재 회차에 들어온 값이 O라면
                score += count // Score에 현재 count값을 더해줌
                count ++ // 이후 카운트에 + 1을 해줌 (O가 연속 되는 경우 추가점수를 얻기 위함)
            } else { // 현재 회차에 입력된 값이 O가 아닌경우 (X일때)
                count = 1 // count는 다시 1로 회귀
            }
        }
        println(score) // 마지막에 저장된 score값을 출력
    }
}



// 첫번째 줄엔 테스트 케이스의 횟수를 받음
// 둘째 줄 부터는 테스트 케이스의 수 만큼의 O와X로 이루어진 문자열을 입력받음
// O는 1점이지만 O가 연속된다면 연속된 수만큼의 추가 점수가 있음
// 예를 들어 OOXXOOXXOO일 경우
// 1+2+0+0+1+2+0+0+1+2 총 9점이 다
// OOOXXXXOOOO 의 경우
// 1+2+3+0+0+0+0+1+2+3+4 = 16점

// 테스트 케이스만큼 반복
// ox로 이루어진 문자열을 받음
// count = o의 연속된 갯수를 세는데 사용 최초에 O가 오는 경우 score값을 구하기 위해 1로 지정
// score 의 초기값은 0으로 지정 (아직 o를 만나지 않았으므로)
// 처음 o를 만났을땐 score += count 이므로 1점, 그리고 count에 1을 더해줌
// 다음에 오는 문자가 O일 경우 이 전에 저장된 값에 현재 count 값을 더해줌
// 다음에 오는 문자가 x일 경우엔 count는 다시 1로 회귀
// 전체 문자 Array를 탐색한 후에 최종 score값을 출력