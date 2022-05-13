import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1620
 * 집합과 맵 문제 포켓몬 탐색하기(?)
 * 도감(map)에 N개의 포켓몬과 포켓몬의 번호를 저장하고
 * 포켓몬의 이름이 입력되면 번호를, 번호가 입력되면 이름을 출력시키는 문제
 * key로 value에 접근하고 value로 key에 접근하는 방법을 사용할 수도 있을거 같은데
 * 방법이나 시간복잡도를 아직 잘 몰라서 map에 번호가 key가 되는 경우와 이름이 key가 되는 경우를 둘 다 put해서 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val pokeDictionarySize = sc.nextInt()
    val myPokemonSize = sc.nextInt()

    val dictionary = hashMapOf<String, String>() // 이름과 번호를 둘다 찾아야 하므로 map을 사용함

    for (i in 0 until pokeDictionarySize) {
        val pokemon = sc.next() // 포켓몬의 이름
        val pokeNumber = (i + 1).toString() // 포켓몬의 번호 (1부터 시작하기 떄문에 i + 1)
        dictionary[pokemon] = pokeNumber // map에 이름을 key로 번호를 value로 put
        dictionary[pokeNumber] = pokemon // map에 번호를 key로 이름을 value로 put
    }
    val sb = StringBuilder()
    for (i in 0 until myPokemonSize) {
        sb.append(dictionary[sc.next().toString()]) // 입력한 포켓몬, 혹은 번호에 매칭되는 value를 StringBuilder에 저장
        sb.append("\n") // 개행
    }
    println(sb)
}