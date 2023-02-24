package se.nackademin

import java.io.File

class FirstDay(private var filePath: String) {

    init {
        if (filePath.isEmpty()) {
            filePath = "src/main/resources/firstReport.txt"
        }
    }

    private val expensesList = File(filePath).readLines().stream()
        .map { it.toInt() }
        .sorted()
        .toList()

    //________________________________ Part 1 ________________________________________________
    fun findTwoNumbersWith(expectedSum: Int): Int {
        var answer = 0
        for (a in expensesList) {
            for (b in expensesList) {
                var sum = (a + b)
                if (sum == expectedSum) {
                    answer = a * b
                }
            }
        }
        return answer
    }

    //______________________________ Part 2 __________________________________________________
    fun findThreeNumbersWith(sum: Int): List<Int> {
        val nums = arrayOf(0, 0, 0)
        for (x in 0..expensesList.size - 1) {
            val a = expensesList[x];
            nums[0] = a;
            val subList = expensesList.subList(x + 1, expensesList.size);
            for (y in 0..subList.size) {
                for (z in y..subList.size) {
                    if (expensesList[y].toInt() + expensesList[z].toInt() == (sum - a)) {
                        nums[1] = expensesList[y];
                        nums[2] = expensesList[z];
                        return nums.toList()
                    }
                }
            }
        }
        return nums.toList()
    }

    fun multipleList(nums: List<Int>): Int {
        return nums.toList()
            .stream()
            .reduce { a, b -> a * b }.get()
    }
}