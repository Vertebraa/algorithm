import java.util.Scanner
import java.util.Stack

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val stack = Stack<Int>()

    val sb = StringBuilder()
    repeat(n) {
//        when (Command.parseOrNull(sc.next())) {
//            Command.PUSH -> stack.push(sc.nextInt())
//            Command.POP -> sb.appendWithLn(stack.popOrNull() ?: -1)
//            Command.SIZE -> sb.appendWithLn(stack.size)
//            Command.EMPTY -> sb.appendWithLn(if (stack.isEmpty()) 1 else 0)
//            Command.TOP -> sb.appendWithLn(stack.peekOrNull() ?: -1)
//            null -> println("잘못된 명령어 입니다.")
//        }
        try {
            when (Command.parse(sc.next())) {
                Command.PUSH -> stack.push(sc.nextInt())
                Command.POP -> sb.appendWithLn(stack.popOrNull() ?: -1)
                Command.SIZE -> sb.appendWithLn(stack.size)
                Command.EMPTY -> sb.appendWithLn(if (stack.isEmpty()) 1 else 0)
                Command.TOP -> sb.appendWithLn(stack.peekOrNull() ?: -1)
            }
        } catch (exception: CommandParseFailException) {
            println(exception.message)
        } catch (exception: Exception) {
            println("알 수 없는 오류 입니다.")
        }

    }
    println(sb)
}

enum class Command(val stringCommand: String) {
    PUSH("push"),
    POP("pop"),
    SIZE("size"),
    EMPTY("empty"),
    TOP("top");

    companion object {
        fun parseOrNull(command: String): Command? {
//            return values()
//                .firstOrNull{ it.stringCommand == command }
//                ?: throw Exception("${command}는 잘못된 명령어 입니다.")
            return when (command) {
                "push" -> PUSH
                "pop" -> POP
                "size" -> SIZE
                "empty" -> EMPTY
                "top" -> TOP
                else -> null
            }
        }

        fun parse(command: String): Command {
//            return values()
//                .firstOrNull{ it.stringCommand == command }
//                ?: throw Exception("${command}는 잘못된 명령어 입니다.")
            return when (command) {
                "push" -> PUSH
                "pop" -> POP
                "size" -> SIZE
                "empty" -> EMPTY
                "top" -> TOP
                else -> throw Exception("${command}은(는) 잘못된 명령어 입니다.")
            }
        }
    }
}

class CommandParseFailException(message: String) : Exception(message)


fun StringBuilder.appendWithLn(n: Any): StringBuilder {
    append(n)
    return appendNewLine()
}

fun StringBuilder.appendNewLine(): StringBuilder {
    return append("\n")
}

fun <T> Stack<T>.popOrNull(): T? {
    return if (isEmpty()) {
        null
    } else {
        pop()
    }
}

fun <T> Stack<T>.peekOrNull(): T? {
    return if (isEmpty()) {
        null
    } else {
        peek()
    }
}