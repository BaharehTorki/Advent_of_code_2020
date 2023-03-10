package se.nackademin

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertEquals as assertEquals1

class Day3Test {

    val listOfTree = ThirdDay("src/test/resources/thirdReport.txt")

    @Test
    fun should_calculateTrees_correct() {
        assertEquals1(79, listOfTree.calculateTrees(1, 1))
        assertEquals1(216, listOfTree.calculateTrees(3, 1))
        assertEquals1(91, listOfTree.calculateTrees(5, 1))
        assertEquals1(96, listOfTree.calculateTrees(7, 1))
        assertEquals1(45, listOfTree.calculateTrees(1, 2))
    }

    @Test
    fun should_return_char_at_index_that_located_in_repeated_field() {
        val example = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÅ1"
        val example1 = "#..#.####....##.#.....#..#....."
        val actualChar1 = ThirdDay("").getCharAt(example, 120)
        val actualChar2 = ThirdDay("").getCharAt(example1, 30)
        val actualChar3 = ThirdDay("").getCharAt(example1, 31)
        val actualChar4 = ThirdDay("").getCharAt(example1, 32)

        assertEquals1('A', actualChar1)
        assertEquals1('.', actualChar2)
        assertEquals1('#', actualChar3)
        assertEquals1('.', actualChar4)
    }

    @Test
    fun calculateTrees2_should_return_multiple_of_each_result() {
        val actual = listOfTree.calculateTrees2()
        val expected = 79 * 216 * 91 * 96 * 45
        assertEquals1(expected, actual)
        println(expected)
    }
}