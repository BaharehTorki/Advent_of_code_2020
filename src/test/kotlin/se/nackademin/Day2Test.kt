package se.nackademin

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2Test {

    @Test
    fun should_recognize_IndexOf_letters_in_password() {
        var example = "TCAAAGMMOTTTVW"
        val actualChar1 = SecondDay("").countCharInString(example, 'T')
        val actualChar2 = SecondDay("").countCharInString(example, 'A')
        val actualChar3 = SecondDay("").countCharInString(example, 'M')
        assertEquals(4, actualChar1)
        assertEquals(3, actualChar2)
        assertEquals(2, actualChar3)
    }

    @Test
    fun should_give_an_array_token_string() {
        var example1 = "5-8 Q: TCQQQGMMQTTTVW"
        var example2 = "3-7 t: kttnjljtttsikt"

        val actualString1 = SecondDay("").stringToMinMaxCharPass(example1)
        val actualString2 = SecondDay("").stringToMinMaxCharPass(example2)
        assertEquals(arrayListOf("5", "8", "Q", "TCQQQGMMQTTTVW"), actualString1)
        assertEquals(arrayListOf("3", "7", "t", "kttnjljtttsikt"), actualString2)

    }

    @Test
    fun countCharInString() {
        val exampleStr = "5-8 Q: TCQQQGMMQTTTVW"
        val exampleChar = 'Q'

        val actualString1 = SecondDay("").countCharInString(exampleStr, exampleChar)
        assertEquals(5, actualString1)

    }

    @Test
    fun should_getIndexes_of_correct_chars() {
        var exampleStr1 = "TCQQQGMMQTTTVW"
        var exampleChar2 = 'Q'
        var exampleStr3 = "kttnjljtttsikt"
        var exampleChar4 = 't'
        var actualInt1 = SecondDay("").getAllIndexes(exampleStr1, exampleChar2)
        var actualInt2 = SecondDay("").getAllIndexes(exampleStr3, exampleChar4)
        assertEquals(listOf(3, 4, 5, 9), actualInt1)
        assertEquals(listOf(2, 3, 8, 9, 10, 14), actualInt2)

    }
}