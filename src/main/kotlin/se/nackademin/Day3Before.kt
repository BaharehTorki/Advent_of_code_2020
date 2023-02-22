package se.nackademin

import java.io.File

class ThirdDay(private var filePath: String) {
    init {
        if (filePath.isEmpty()) {
            filePath = "src/main/resources/thirdReport.txt"
        }
    }

    private val fileInfo = File(filePath).readLines()
    fun calculateTrees(): Int {
        var index1 = 0
        return fileInfo.subList(1, fileInfo.size)
            .stream()
            .map { row ->
                index1 += 3
                getCharAt(row, index1)
            }
            .filter() { char ->
                char.equals('#')
            }
            .count().toInt()
    }

    fun getCharAt(str: String, i: Int): Char {
        return try {
            str[i]
        } catch (e: StringIndexOutOfBoundsException) {
            getCharAt(str, i - str.length)
        }
    }
}
