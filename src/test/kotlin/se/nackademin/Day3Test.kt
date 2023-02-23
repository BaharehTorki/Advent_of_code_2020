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
        val example1 = "#..#.####....##.#.....#..#....."
        val actualChar1 = ThirdDay("").getCharAt(example, 120)
        val actualChar2 = ThirdDay("").getCharAt(example1, 30)
        val actualChar3 = ThirdDay("").getCharAt(example1, 31)
        val actualChar4 = ThirdDay("").getCharAt(example1, 32)

        assertEquals('A', actualChar1)
        assertEquals('.', actualChar2)
        assertEquals('#', actualChar3)
        assertEquals('.', actualChar4)
    }
}