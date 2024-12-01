package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day1

class Day1Test: BaseTest<Day1>(inputStringOne, inputStringTwo, ::Day1) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("11", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("31", result)
    }

    private companion object {
        const val inputStringOne = "3   4\n" +
                "4   3\n" +
                "2   5\n" +
                "1   3\n" +
                "3   9\n" +
                "3   3"

        const val inputStringTwo = "3   4\n" +
                "4   3\n" +
                "2   5\n" +
                "1   3\n" +
                "3   9\n" +
                "3   3"
    }
}