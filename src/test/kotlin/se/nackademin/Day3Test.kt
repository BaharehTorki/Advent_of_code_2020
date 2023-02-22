package se.nackademin

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3Test{

    @Test
    fun should_return_correct_steps() {
        val actualTree = ThirdDay("src/test/resources/test.txt").calculateTrees()
        assertEquals(5 ,actualTree)
    }

    @Test
    fun should_return_char_at_index_that_located_in_repeated_field() {
        val example = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÅ1"
        val actualChar = ThirdDay("").getCharAt(example, 120);

        assertEquals('A', actualChar)
    }
}