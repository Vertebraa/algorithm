import java.util.*

/**
 * https://www.acmicpc.net/problem/11650
 * 정렬 문제 좌표 정렬하기
 * x와 y중 x 좌표를 우선 오름차순 정렬하고 x좌표가 같을 경우 y좌표를 오름차순으로 정리
 * 리스트에 각 index에 두개의 변수를 넣기위해 data class를 사용해서 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt()
    val list = mutableListOf<Coordinate>()

    for (i in 0 until testCase) { // 몇개의 좌표가 들어갈 것인지 제한
        val x = sc.nextInt() // x좌표를 입력받음
        val y = sc.nextInt() // y좌표를 입력받음
        val coordinate = Coordinate(x, y) // data class x값과 y값을 변수화
        list.add(coordinate)
    }

    list.sortWith(compareBy({ it.y }, { it.x })) // x를 우선하여 sort하고 다음으로 y를 sort함
    list.forEach { println("${it.x} ${it.y}") }
}

data class Coordinate(
    val x: Int,
    val y: Int
)