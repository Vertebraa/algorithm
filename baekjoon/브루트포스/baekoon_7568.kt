import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/7568
 * 브루트포스 문제 덩치가 큰 순서대로 사람들의 순위를 출력하는 문제
 * 덩치가 큰 기준은 몸무게와 신장이 둘다 큰 경우이다, 둘장 하나라도 비교군에 비해 작은게 있다면 비교불가
 * 자신 보다 큰 사람의 수 + 1이 해당 인물의 덩치 순위 이므로
 * 최초 순위를 1로 지정하고 나보다 큰사람이 있으면 순위에 1을 더해주고
 * 결정된 순위를 배열에 담아 그 배열을 출력하는 것으로 풀이함
 */

fun main() = Scanner(System.`in`).use { sc ->
    val n = sc.nextInt()
    val bodyInfoList = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        bodyInfoList.add(Pair(sc.nextInt(), sc.nextInt())) // 입력받은 무게와 신장을 pair로 저장
    }

    val ranking = IntArray(n)
    for (i in 0 until n) { // i 번째 사람과 다른 사람을 비교
        var rank = 1
        for (j in 0 until n) {
            if (i != j) { // 본인과는 비교할 필요가 없음
                if (bodyInfoList[i].first < bodyInfoList[j].first && bodyInfoList[i].second < bodyInfoList[j].second) {
                    rank++ // 다른 사람이 비교대상보다 덩치가 크다면 랭크 ++
                }
            }
        }
        ranking[i] = rank // 비교한 후 i의 순위를 배열에 넣어줌
    }
    print(ranking.joinToString(separator = " ")) // 랭킹을 공백으로 구분해서 출력함
}