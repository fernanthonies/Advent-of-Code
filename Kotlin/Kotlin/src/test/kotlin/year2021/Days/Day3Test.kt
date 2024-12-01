package year2021.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2021.Days.Day3

class Day3Test: BaseTest<Day3>(inputStringOne, inputStringTwo, ::Day3) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("198", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("", result)
    }

    private companion object {
        const val inputStringOne = "00100\n" +
                "11110\n" +
                "10110\n" +
                "10111\n" +
                "10101\n" +
                "01111\n" +
                "00111\n" +
                "11100\n" +
                "10000\n" +
                "11001\n" +
                "00010\n" +
                "01010"

        const val inputStringTwo = "00100\n" +
                "11110\n" +
                "10110\n" +
                "10111\n" +
                "10101\n" +
                "01111\n" +
                "00111\n" +
                "11100\n" +
                "10000\n" +
                "11001\n" +
                "00010\n" +
                "01010"
    }
}