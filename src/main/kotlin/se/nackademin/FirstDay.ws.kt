package adventOfCode.calenda2020

import java.io.File


val expensesList = File("src/main/resources/firstDaysReport.txt")
    .readLines()
    .map { it.toInt() }
    .sorted().toList().toMutableList();

/*fun main(args: Array<String>) {
    //calc();
    *//*firstStep1()
    firstStep2()
    firstStep3()
    calculate()*//*
    for (n in expensesList) {
        println(isSum2020(n))

    }
}*/


fun main(args: Array<String>) {
    calcTwoNr()
    //isSum2020(c)
    var counter = 1;
    expensesList.stream().anyMatch()
    { calcThreeNr(it, expensesList.subList(counter++, expensesList.size)) }
}


fun calcTwoNr() {
    println(expensesList)
    for (a in expensesList) {
        for (b in expensesList) {
            var sum = (a + b)

            if (sum == 2020) {
                val answer = a * b
                println("The sum of two numbers for 2020: $a * $b = $answer")
            }
        }
    }
}

fun calcThreeNr(a: Int, listOf: List<Int>): Boolean {
    for (b in listOf) {
        listOf.stream().forEach() { item ->
            if (b.plus(a).plus(item).equals(2020)) {
                println(String.format("The sum of three numbers to 2020: $a, $b, $item"))
                return@forEach
            }
        }
    }
    return false;
}

fun isSum2020(c: Int): List<String> {
    var array1 = arrayListOf<String>()
    for (a in expensesList) {
        for (b in expensesList) {
            var sum = (a + b)

            if (sum == 2020 - c) {
                array1.add(String.format("{a = %d, b = %d , c = %d}", a, b, c))
            }
        }
    }
    return array1
}



fun firstStep2() {
    repeat(2) {
        for (a in expensesList) {
            for (b in expensesList) {
                for (c in expensesList) {
                    var sum = (a + b + c)

                    if (sum == 2020) {
                        val answer = (a * b * c)
                        println("$a * $b * $c = $answer")
                    }
                }
            }
        }
    }
}

fun firstStep3() {
    val list1 = listOf<Any>(expensesList)
    var n = 0
    println(list1.mapIndexed { index: Int, i ->
        for (i in list1) {
            //var next = i + list1[n++]
        }
        list1.get(0)
    })
}

fun calc() {
    val nums = arrayOf(0, 0, 0)
    for (x in 0..expensesList.size - 1) {
        val a = expensesList[x];
        nums[0] = a;
        val subList = expensesList.subList(x + 1, expensesList.size);
        for (y in 0..subList.size) {
            for (z in y..subList.size) {
                if (y + z == (2020 - a)) {
                    nums[1] = y;
                    nums[2] = z;
                    println(nums);
                }
            }
        }
    }
}

fun calculate() {
    val list = mutableListOf<MutableList<Int>>(expensesList)
    var index = 0
    for (x in list) {
        var next = x + (index++)
        println(next)
    }
}
