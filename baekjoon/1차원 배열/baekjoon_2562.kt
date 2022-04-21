import java.util.*

/**
 * https://www.acmicpc.net/problem/2562
 * 1차원 배열 최댓값과 최댓값이 몇번째 숫자인지 구하는 문제
 * Array와 같은 배열을 사용하지 않고 반복문만 사용해서 풀이함
 * max(최댓값)와 count(몇번째) 변수를 mutable로 선언
 * 반복문 실행마다 두 값을 초기화
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)

    var max = 0 // 최초 max의 변수값 (자연수 이므로 0으로 지정시 항상 옳은 값 기록)
    var count = 0 // 최초 count의 변수값 (숫자의 순서는 1부터 시작하므로 항상 옳은 값 기록)

    for (i in 0 until 9) { // 반복문의 횟수(문제에서 지정)를 제한
        val num = sc.nextInt() // 자연수를 입력받음
        if (max < num) {
            max = num // 다음에 오는 자연수가 현재의 max값보다 클경우 해당 값으로 max 변수를 초기화
            count = i + 1 // 위조건 충족 시 자연수의 번호(=index + 1)로 count 변수를 초기화
        }
    }
    println(max) // 마지막 반복 후 최후에 저장된 max값 출력
    println(count) // 마지막 반복 후 최후에 저장된 count값 출력
}



// 9개의 무작위 숫자를 입력 받음
// 예를 들어 i가 3까지 이면
// i가 1일때
// 첫 번째 숫자를 받아옴
// max로 최초 설정한 값과 비교해 (MIN VALUE를 사용할 수 있지만 문제에서 자연수로 명시했기에 0으로 함)입력받은 정수가 크면 해당값을 저장
// max값이 새로 초기화 되는 경우, i (index번호) + 1 = 몇번째 숫자를 count에 저장
// i가 2일때
// 두 번째 숫자를 받아옴
// i가 1일때 저장한 max 값보다 입력받은 정수가 크면 max를 해당 정수로 초기화
// max값이 새로 초기화 되는 경우, i (index번호) + 1 = 몇번째 숫자를 count에 저장
// i가 3일때
// 세 번째 숫자를 받아옴
// i가 2일때 저장한 max 값보다 입력받은 정수가 크면 max를 해당 정수로 초기화
// max값이 새로 초기화 되는 경우, i (index번호) + 1 = 몇번째 숫자를 count에 저장
// 결과적으로 반복 종료 후엔 가장큰 정수로 max값 초기화, i값 + 1을 count로 초기화
// 반복 종료후 조건에 성립하는(마지막으로 저장된) max와 count를 출력
