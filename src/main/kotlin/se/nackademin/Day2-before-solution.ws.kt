package se.nackademin

import java.io.File

class SecondDay(private var filePath: String) {
    init {
        if (filePath.isEmpty()) {
            filePath = "src/main/resources/secondReport.txt"
        }
    }
    private val passwordList1 = File(filePath).readLines().toList().toMutableList()

    fun countCorrectPasswordWithFirstPart(): Int {
        return passwordList1.stream()
            .map(this::stringToMinMaxCharPass)
            .filter(this::isValidPass)
            .count()
            .toInt()
    }

    fun countCorrectPasswordWithSecondPart(): Int {
        return passwordList1.stream()
            .map { item ->
                stringToMinMaxCharPass(item)
            }
            //example:   [0]: "5",    [1]: "10",     [2]: "b",    [3]:    "bhbjlkbbbbbbb"
            .filter() { conditionAndString ->

                //to be checked that value of:  [2]: "b",   exist in String   [3]:    "bhbjlkbbbbbbb"
                val allIndexes = getAllIndexes(conditionAndString[3], conditionAndString[2].get(0))

                //if exist in index   [0]:"5"   OR    [1]:"10"
                (allIndexes.contains(conditionAndString[0].toInt()) xor allIndexes.contains(conditionAndString[1].toInt()))
            }.count().toInt()
    }

//_____________________________PART1_____________________________

    fun isValidPass(minMaxCharPass: List<String>): Boolean {
        val countCharInString = countCharInString(minMaxCharPass[3], minMaxCharPass[2].get(0))
        return ((minMaxCharPass[0].toInt() <= countCharInString) and (countCharInString <= minMaxCharPass[1].toInt()))
    }

    //[2]: "b",   [3]:    "bhbjlkbbbbbbb"
    fun countCharInString(pass: String, char: Char): Int {
        return pass.toList().stream()
            .filter() { c -> c.equals(char) }
            .count().toInt();
    }

//________________________ PART1 & PART2 ______________________

    //example => String:  "5-10 b: bhbjlkbbbbbbb"
    fun stringToMinMaxCharPass(item: String): List<String> {
        val arrayList = ArrayList<String>()

        //    5-10 b:  /     bhbjlkbbbbbbb
        val twoFirst = item.split(": ")

        //    5-10     /     b:
        val firstPart = twoFirst[0].split(" ")

        //    5        /     10
        val nums = firstPart[0].split("-")
        arrayList.add(nums[0])  //5
        arrayList.add(nums[1])  //10

        // arrayList:   [0]: 5-10     /    [1]:  b:
        arrayList.add(firstPart[1])

        //arrayList:    [0]: 5-10 b   /    [1]:bhbjlkbbbbbbb
        arrayList.add(twoFirst[1])

        //arrayList:    [0]: 5        /    [1]:10     /     [2]:b    /    [3]:bhbjlkbbbbbbb
        return arrayList
    }

//_____________________________PART2_____________________________

    //char: 'b'     pass: "bhbjlkbbbbbbb"
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

}



