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
                //The Kotlin List.drop() function returns a list containing all elements except first n elements.
                .drop(aIdx + 1)

                //Returns a list containing only the non-null results of applying the given transform function to each element and its index in the original array.
                .mapIndexedNotNull { bIdx, b ->
                    input
                        .drop(bIdx + 1)

                        //Returns a list containing all elements except first elements that satisfy the given predicate
                        .dropWhile { a + b + it < 2020 }

                        //Returns a string containing the first n characters from this string, or the entire string if this string is shorter.
                        .take(1)

                        //To get the first element of the ArrayList . If the ArrayList is empty, then null is returned.
                        .firstOrNull { a + b + it == 2020 }

                        //let takes the object it is invoked upon as the parameter and returns the result of the lambda expression.
                        ?.let { a * b * it }
                }.firstOrNull()
            //Returns the first element.
        }.first()

}
