import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime

fun main() {
    val id = 40

    println("Hello, Kotlin")
    println(check50Over(id))

    whenExample(id)

    val dog = Dog("taro")
    dog.showName()
    dog.cries()
    listExample()
    mapExample()
    useUser()
    coroutines()
    callJava()
    callLocalDateTime()
    greet()
    val function = CalcJava { num1, num2 -> num1 + num2 }
    executeCalc(1, 3, function)

}

fun check50Over(number: Int): Boolean {
    return 50 < number
}

fun whenExample(int: Int) {
    when (int) {
        200 -> {
            println("Equal 200")
        }

        300 -> {
            println("Equal 300")
        }

        else -> {
            println("other")
        }
    }

    when {
        int < 100 -> println("less than 100")

        int == 100 -> {
            println("Equal 100")
        }

        else -> {
            println("greater than 100")
        }
    }

    val whenText = when {
        int < 100 -> "less than 100"
        int == 100 -> {
            "Equal 100"
        }

        else -> {
            "greater than 100"
        }
    }
    println("whenText: $whenText")

    if (int < 100) {
        println("less than 100")
    } else if (int == 100) {
        println("Equal 100")
    } else {
        println("greater than 100")
    }

    val ifText = if (int < 100) {
        "less than 100"
    } else {
        "greater than 100"
    }
    println("text: $ifText")
}

fun listExample() {
    val intList: List<Int> = listOf(1, 2)
    for (i in intList) {
        println("intList: $i")
    }
    intList.forEach {
        println(it)
    }
    intList.first { it == 1 }
    val mutableList: MutableList<Int> = mutableListOf()
    mutableList.addAll(5..8)
    for (i in mutableList) {
        println("mutableList: $i")
    }
}

fun mapExample() {
    val map: Map<Int, String> = mapOf(1 to "one", 2 to "two")
    for (entry in map) {
        println("key: ${entry.key}, value: ${entry.value}")
    }
    println("containsKey 1: ${map.containsKey(1)}")
    println("containsKey 3: ${map.containsKey(3)}")

    val mutableMap: MutableMap<Int, String> = mutableMapOf()
    mutableMap[4] = "four"
    for (mutableEntry in mutableMap) {
        println("mutableMap.key: ${mutableEntry.key}, mutableMap.value: ${mutableEntry.value}")
    }
}

fun useUser() {
    val user = User("taro")
    // プロパティを遅延初期化する必要があるため、実行時エラーになる
    // println("user.isValidName: ${user.isValidName}")
    println("user.isValidName: ${user.isValidName}")
    println("user.name: ${user.name}")
    println("user.favoriteFood: ${user.favoriteFood}")
    user.favoriteFood = ""
    println("user.favoriteFood: ${user.favoriteFood}")
    user.favoriteFood = "sushi"
    println("user.favoriteFood: ${user.favoriteFood}")
}

fun createUser(name: String?): User? {
    return name?.let { User(it) }
}

fun coroutines() {
    GlobalScope.launch {
        delay(1000L)
        println("huge")
    }
    print("My name is ")
    Thread.sleep(2000L)
}

fun callJava() {
    val hello = HelloByJava()
    hello.printHello()
}

fun callLocalDateTime() {
    val now = LocalDateTime.now()
    println(now)
}

fun greet() {
    val greet = GreeterImplKotlin()
    greet.hello()
}

fun executeCalc(num1: Int, num2: Int, function: CalcJava) {
    println(function.calc(num1, num2))
}