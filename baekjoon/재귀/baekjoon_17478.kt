import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/17478
 * 재귀함수 문제 재귀횟수에 따른 챗봇의 응답 출력하기
 * 재귀함수의 구조를 이해할때 좋은 문제인것 같음
 * stack의 형태로 함수가(탈출 조건까지) 적립된다고 생각하니 이해가 쉬웠음
 */


fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val count = sc.nextInt()

    println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.") // 한번만 등장하는 문장
    println(recursive(count, ""))
}


private fun recursive(n: Int, underBar:String): String {
    println("$underBar\"재귀함수가 뭔가요?\"")
    val answer = "라고 답변하였지."

    if (n == 0) { // 탈출조건
        println("$underBar\"재귀함수는 자기 자신을 호출하는 함수라네\"")
        return underBar + answer
    }
    // 탈출조건 이외의 경우 n값을 1씩 줄여가며 ____를 underBar에 추가해서 아래 출력을 재귀(반복)함
    println("$underBar\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.")
    println(underBar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.")
    println(underBar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"")

    println(recursive(n - 1, underBar + "____"))
    return underBar + answer
}

// 재귀함수의 구조의 이해가 부족해서 상당히 많이 애먹었다
// 최초 16번에서 recursive 함수를 호출했을때
// n이 2라고 가정하면 21번 코드 이후 29번 코드부터 33번 까지 실행되고 (함수 1이라고 약칭함) 이때 underBar는 ""
// n이 1일때의 recursive가 실행됨 다시 underBar에 ____가 더해지고 21번부터 33번 까지 실행되고 (함수 2)
// n이 0이되며 탈출조건을 만남 return을 실행하고(함수 3) 함수2의 return을 반환 함수 1의 return을 반환하는 식
// stack의 형태로 함수 1안에서 2를 만나고 함수3에서 탈출(=return) 3이 종료됐으니 2를 마저 종료 이후 1을 종료하는 형태