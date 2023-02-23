package se.nackademin

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

    @Test
    fun should_calculate_sum_Of_Two_number_And_then_their_multiplication() {
    var example = listOf(5, 15, 20, 8, 7, 10)
        var actualList = FirstDay("").calcTwoNr(example)
        assertEquals<Any>(300, actualList)
    }

    @Test
    fun should_calculate_sum_Of_three_number_And_then_their_multiplication() {
        var example = listOf(5, 15, 20, 8, 7, 10)
        var actualList = FirstDay("").firstStep2(example)
        assertEquals<Any>(560, actualList)
    }


}