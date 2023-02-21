package se.nackademin


import java.io.File

val passwordList1 = File("src/main/resources/secondDaysReport.txt").readLines().toList().toMutableList()

fun main() {
    val resultList = ArrayList<Boolean>()
    val a = passwordList1.stream()
        .map { item -> mapToList(item) }
        .filter() { conditionAndString ->
            val allIndexes = getAllIndexes(conditionAndString[3], conditionAndString[2].get(0))
            (allIndexes.contains(conditionAndString[0].toInt()) xor allIndexes.contains(conditionAndString[1].toInt()))
        }.count()

println(a)

}

fun mapToList(item: String): List<String> {
    val arrayList = ArrayList<String>();

    val twoFirst = item.split(": ")
    val fitstPart = twoFirst[0].split(" ")
    val nums = fitstPart[0].split("-")
    arrayList.add(nums[0])
    arrayList.add(nums[1])
    arrayList.add(fitstPart[1])
    arrayList.add(twoFirst[1])
    return arrayList
}

fun isCorrect(conditionAndStringList: List<String>): Boolean {

    val countCharInString = countCharInString(conditionAndStringList[3], conditionAndStringList[2].get(0))

    return ((conditionAndStringList[0].toLong() <= countCharInString) and (countCharInString <= conditionAndStringList[1].toLong()))
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
    var index = 0;
    val intList = ArrayList<Int>()

    pass.toList().forEach() { item ->
        index++
        if (item.equals(char)) {
            intList.add(index)
        }
    }
    return intList
}








