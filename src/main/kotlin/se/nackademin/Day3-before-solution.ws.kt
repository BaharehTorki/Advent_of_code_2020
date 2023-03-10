package se.nackademin

import java.io.File
class ThirdDay(private var filePath: String) {
    init {
        if (filePath.isEmpty()) {
            filePath = "src/main/resources/thirdReport.txt"
        }
    }

    private val listOfData = File(filePath).readLines()

    fun calculateTrees(right: Int, down: Int): Long {
        var index1 = 0
        return listOfData.subList(1, listOfData.size).chunked(down)
            .stream()
            .filter() { item -> item.size == down }
            .map() { i -> i.get(down - 1) }
            .map { row ->
                index1 += right
                getCharAt(row, index1)
            }
            .filter() { char ->
                char.equals('#')
            }
            .count()
    }

    fun getCharAt(str: String, i: Int): Char {
        return try {
            str[i]
        } catch (e: StringIndexOutOfBoundsException) {
            getCharAt(str, i - str.length)
        }
    }

    //_________________________________PART2_______________________________________
    fun calculateTrees2(): Long {
        return listOf(
            1 to 1,
            3 to 1,
            5 to 1,
            7 to 1,
            1 to 2,
        ).stream()
            .map() { (r, d) -> calculateTrees(r, d) }
            .reduce { a, b -> a * b }
            .get()
    }

}
