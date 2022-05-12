import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/10814
 * 정렬 문제 회원을 나이순으로 정렬하고, 나이가 같은 경우 먼저 가입한 순으로 출력하라
 * 이전 좌표 문제와 동일하게 data class를 만들어서 회원의 정보를 리스트에 입력하고
 * 회원 정보 이외에 add된 순서 (i)를 변수에 추가해주고
 * sort 우선 순위를 나이, 가입순서로 해서 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt()
    val memberList = mutableListOf<MemberInfo>() // 회원들의 정보가 들어갈 리스트

    for (i in 0 until testCase) {
        val age = sc.nextInt()
        val name = sc.next()
        val accountNumber = i // 추가되는 순서 (= 가입순서)
        val memberInfo = MemberInfo(age, name, accountNumber) // 위의 세 정보가 담긴 변수
        memberList.add(memberInfo) // list에 add
    }
    memberList.sortWith(compareBy({it.age},{it.accountNumber})) // 고려 순서를 age, 가입순서로 정렬함
    memberList.forEach { println("${it.age} ${it.name}") }
}

data class MemberInfo(
    val age: Int,
    val name: String,
    val accountNumber: Int // 출력하진 않지만 내부에 가입 순서를 만들기 위해 data class내에 변수 생성
)
