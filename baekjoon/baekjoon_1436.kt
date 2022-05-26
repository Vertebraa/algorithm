import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1436
 * 브루트포스 문제 영화제목 선정하기
 * 영화 제목에는 666이 포함 되어야만 한다 1편은 666 2편은 1666 3편은 2666 이런식으로
 * 영화의 n편, 즉, n번째 영화의 제목을 출력하는 문제 ( 666이 n번 등장하는 최소 값)
 * 등장 횟수를 var 0으로 선언하고 666이 포함되는 숫자를 만날 때마다 횟수를 더해준다
 * 그리고 입력한 n과 등장 횟수가 같아 질 때 해당 숫자를 출력해서 풀이함
 */

fun main() = Scanner(System.`in`).use { sc ->
    val n = sc.nextInt()

    var count = 0 // 등장 횟수
    var number = 0 // 영화의 제목이 될 숫자
    val beastNumber = "666"
    while (count != n) { // 등장횟수가 입력한 값이 아닐 때에만 반복
        number++ // 0 부터 1씩 더해주며 탐색 시작
        if (beastNumber in number.toString()) { // 정수를 string으로 만들어주고 해당 정수가 666을 포함 하고 있다면
            count++ // 등장 횟수 ++
        }
    }
    print(number)
}