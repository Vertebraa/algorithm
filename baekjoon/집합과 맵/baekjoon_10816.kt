import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/10816
 * 집합과 맵 문제 두 뭉치의 숫자 카드중 일치하는 갯수 출력하기
 * 숫자가 적힌 n개의 카드와 숫자가 적힌 m개의 카드를 입력 받고
 * 카드 뭉치 m의 각 숫자가 카드 뭉치 n에서 몇 번씩 쓰였는지 출력하는 문제
 * 한번도 쓰이지 않았다면 0을 출력
 * 예를 들어 n의 카드가 10 10 10 이고 m의 카드가 10 9 8 이면 3 0 0 을 출력
 * hashMap에 n의 각 숫자를 key로 지정하고 value에 중복횟수를 더해가는 방법으로 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val myCard = hashMapOf<Int, Int>()

    repeat(n) {
        val firstCard = sc.nextInt()
        myCard[firstCard] = myCard[firstCard]?.plus(1) ?: 1
        // 입력 받은 숫자 = key, key에 대응되는 value가 있다면(if not null) + 1, 없다면(if null) value = 1
    }

    val sb = StringBuilder()
    val m = sc.nextInt()

    repeat(m) {
        val secondCard = sc.nextInt()
        sb.append(myCard[secondCard] ?: 0)
        // StringBuilder에 입력한 숫자(key)로 접근되는 value를 저장, 없다면(if null) 0를 저장
        sb.append(' ') // 공백으로 각 숫자를 구분
    }
    print(sb.toString().trim()) // 문자열의 맨 앞과 맨뒤의 공백을 제거하고 출력
}