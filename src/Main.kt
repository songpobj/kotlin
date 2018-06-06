import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
//    val result=double(5.0)
//    println("double(5) = $result")
//    myName("RUN")
//    getCount()
//    getSum()
//    checkInput(20)
//    checkInput(120)
//    checkScore(10)
//    checkScore(80)

//    checkScore2(1)
//    checkScore2(2)
//    checkScore2(3)

//    checkScore3(1)
//    checkScore3(30)
//    checkScore3(45)
//    checkScore3(55)
//    checkScore3(67)
//    checkScore3(72)
//    checkScore3(85)
//    checkScore3(90)

    val date = Date()
    val format = SimpleDateFormat("MMyy", Locale.ENGLISH)
    val mmyy =  format.format(date)
    println(mmyy)
    val pass = HashPassword.genPassword(mmyy)
    println("Password: " + pass)
    if (HashPassword.getIsValid(pass, mmyy)) {
        println("True")
    } else {
        println("False")
    }
}

fun double(amount: Double): Double {
    return amount * 2
}

fun myName(name: String) {
    println("My name is $name")
}

private val arrayList = arrayListOf("A", "B")

fun getCount() {
    var items = arrayListOf("A", "B")
    println("count = ${items.size}")
}

fun getSum() {
    var items = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println("Sum = ${items.sum()}")
}

fun checkInput(input: Int) {
    var num = input
    if (num > 100) num = 100
    println("num = $num")
}

fun checkScore(input: Int) {
    var pass: Boolean = false
    if (input <= 50) {
        pass = false
    } else {
        pass = true
    }
    println(" score $input -> $pass")
}

fun checkScore2(input: Int) {
    when (input) {
        1 -> println("$input * 1")
        2 -> println("$input * 2")
        else -> println("$input * 99")
    }
}

fun checkScore3(input: Int) {
    when (input) {
        in 50..59 -> println(" $input = D")
        in 60..69 -> println(" $input = C")
        in 70..79 -> println(" $input = B")
        in 80..100 -> println(" $input = A")
        else -> println(" $input = F")
    }
}