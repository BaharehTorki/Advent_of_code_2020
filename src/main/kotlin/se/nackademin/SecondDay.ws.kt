package adventOfCode.calenda2020

import java.io.File
import kotlin.jvm.optionals.asSequence

val passwordList1 = File("src/main/resources/secondDaysReport.txt").readLines().toList().toMutableList()

fun main() {
//    7-10 v: mgvrwvvsjw

    val allIndexes = getAllIndexes("mgvrwvvsjw", 'v')
    println(allIndexes)

    if (allIndexes.contains(1) xor allIndexes.contains(5))
        println("Yeeesss")
    else
        println("NOOOOOO")

    val count = passwordList1.stream()
        .map() { item -> mapToList(item) }
        .filter() { item -> isCorrect(item) }
        .count()
    println(count)

}

fun mapToList(item: String): List<String> {
    return item.split(": ")
    println(item)
}

fun isCorrect(item: List<String>): Boolean {
    val controller = item[0].split(" ")
    val minMax = controller[0].split("-")
    val countCharInString = countCharInString(item[1], controller[1].get(0))

    return ((minMax[0].toLong() <= countCharInString) and (countCharInString <= minMax[1].toLong()))
}

fun countCharInString(pass: String, char: Char): Long {
    return pass.toList().stream()
        .filter() { c -> c.equals(char) }
        .count();
}

//_____________________________PART2_____________________________

/*     if (intList.contains(minMax[0]) xor intList.contains(minMax[1]))

*   getAllIndexes(wwzwwdfgwwp , w) -> intList[0,1,3,4,8,9]
*
* */
fun getAllIndexes(pass: String, char: Char): List<Int> {
    var index = -1;
    val intList = ArrayList<Int>()

    pass.toList().forEach() { item ->
        index++
        if (item.equals(char)) {
            intList.add(index)
        }
    }
    return intList
}








