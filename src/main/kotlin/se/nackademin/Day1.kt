package se.nackademin

//_________________________Solution by help other's idea___________________________________________

//create a class in its input as a list of numbers
class Day01(data: List<Int>) {

    //A property for taking data and sorted metod
    private val input = data.sorted()


    fun solvePart1(): Int =
    //taking only the non-null results of applying the given data
        // each element and its index in the original array

        input.mapIndexedNotNull { idx, a ->
            input
                .drop(idx + 1)
                .dropWhile { a + it < 2020 }
                .take(1)
                .firstOrNull { a + it == 2020 }
                ?.let { a * it }
        }.first()

    fun solvePart2(): Int =
        input.mapIndexedNotNull { aIdx, a ->
            input
                .drop(aIdx + 1)
                .mapIndexedNotNull { bIdx, b ->
                    input
                        .drop(bIdx + 1)
                        .dropWhile { a + b + it < 2020 }
                        .take(1)
                        .firstOrNull { a + b + it == 2020 }
                        ?.let { a * b * it }
                }.firstOrNull()
        }.first()

}
