import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2884
 * 조건문을 사용해 알람 시계 시간 구하기
 *
 * 현재 시간에서 45분 전으로 돌아 갔을 때 시간의 변화가 있다면 입력된 시간 값에서 1을 빼서 출력함
 * 시간의 변화는 입력된 분에서 45을 뺐을 때 값이 음수라면 시간의 변화가 있는것
 * 만약 입력한 시간이 0시 (24시)라면 45분을 돌렸을 때 시간이 음수가 되므로 전일 23시로 출력
 * 현재 시간에서 45분 전으로 돌아 갔을 때 시간의 변화가 없다면 입력된 시간 값을 그대로 출력
 *
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val hour = sc.nextInt()
    val minute = sc.nextInt()

    if (hour in 0..23 && minute in 0..59) { // 시간과 분의 한계를 제한
        if (minute - 45 < 0) { // 현재 '분'에서 45분을 뺐을때 음수인 경우 시간의 변화가 생김
            val currentMinute = 60 + (minute - 45) // 시간의 변화가 생기는 경우 현재 '분'을 표기
            if (hour == 0) { // 입력된 시간이 0시 일 때
                println("23 $currentMinute") // 시간이 음수가 되므로 전일 23시 + 현재 '분'을 출력
            } else {  // 시간이 음수가 되지 않는 경우
                println("${hour - 1} $currentMinute") // 입력한 시간에서 1을 빼고 현재 '분'을 출력
            }
        } else { // 시간의 변화가 없는 경우
            println("$hour ${minute - 45}") // 입력한 시간을 그대로 출력 + 현재 '분'에서 45를 빼고 출력
        }
    }
}
