package se.nackademin

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3Test {

    val listOfTree = ThirdDay("src/test/resources/thirdReport.txt")

    @Test
    fun should_calculateTrees_correct() {
        assertEquals(79, listOfTree.calculateTrees(1, 1))
        assertEquals(216, listOfTree.calculateTrees(3, 1))
        assertEquals(91, listOfTree.calculateTrees(5, 1))
        assertEquals(96, listOfTree.calculateTrees(7, 1))
        assertEquals(45, listOfTree.calculateTrees(1, 2))
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

    @Test
    fun calculateTrees2_should_return_multiple_of_each_result() {
        val actual = listOfTree.calculateTrees2()
        val expected = 79*216*91*96*45
        assertEquals(expected, actual)
    }

}