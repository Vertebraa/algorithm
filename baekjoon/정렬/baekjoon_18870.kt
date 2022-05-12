import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/18870
 * 정렬 문제 좌표 압축 문제
 * 좌표의 값보단 압축좌표를 얻기위해 각 좌표들의 순서 (여기선 i)에 접근하는게 중요함
 * 중복을 제거해야 각 좌표가 접근할수 있는 index번호(=압축 좌표)가 나오기 때문에 mutableMap을 사용함
 * 각 좌표의 값을 key로 지정하고 압축 좌표를 value로 설정해 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt()
    val list = IntArray(testCase) { sc.nextInt() }
    val coordinateMap = mutableMapOf<Int, Int>() // 입력한 좌표에 동일한 값이 있을수 있으니 mutableMap(hashMap)을 사용함

    list.forEach {
        coordinateMap[it] = 0 // map의 key로 list의 값을 넣어줌
    }
    coordinateMap.keys // map의 key에 접근
        .sorted() // 오름차순으로 정렬함
        .forEachIndexed { i, inputCoordinate -> // index와 입력된 값을 함께 리턴해줌
            coordinateMap[inputCoordinate] = i // list의 좌표를 key로 매칭되는 index번호를 value로 만듬
        }
    val sb = StringBuilder()
    list.forEach { key -> coordinateMap[key]?.let { value -> sb.append("$value ") } }
    print(sb.toString())
}
