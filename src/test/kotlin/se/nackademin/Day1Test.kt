package se.nackademin

import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class Day1Test {
    val firstDay = FirstDay("src/test/resources/numbers")

    @Test
    fun should_calculate_sum_Of_Two_number_And_then_their_multiplication() {
        val actual = firstDay.findTwoNumbersWith(100)
        assertEquals<Any>(900, actual)
    }

    @Test
    fun should_calculate_sum_Of_three_number_And_then_their_multiplication() {
        val threeNums = firstDay.findThreeNumbersWith(20)
        val actual = firstDay.multipleList(threeNums)
        assertEquals(88, actual)
    }

}