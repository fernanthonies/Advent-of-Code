package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day2

class Day2Test: BaseTest<Day2>(inputStringOne, inputStringTwo, ::Day2) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("2", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("4", result)
    }

    private companion object {
        const val inputStringOne = "7 6 4 2 1\n" +
                                    "1 2 7 8 9\n" +
                                    "9 7 6 2 1\n" +
                                    "1 3 2 4 5\n" +
                                    "8 6 4 4 1\n" +
                                    "1 3 6 7 9"

        const val inputStringTwo = "7 6 4 2 1\n" +
                                    "1 2 7 8 9\n" +
                                    "9 7 6 2 1\n" +
                                    "1 3 2 4 5\n" +
                                    "8 6 4 4 1\n" +
                                    "1 3 6 7 9"
    }
}