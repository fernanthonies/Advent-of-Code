package year2025.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Test: BaseTest<Day1>(inputStringOne, inputStringTwo, ::Day1) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("3", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("6", result)
    }

    private companion object {
        const val inputStringOne = "L68\n" +
                "L30\n" +
                "R48\n" +
                "L5\n" +
                "R60\n" +
                "L55\n" +
                "L1\n" +
                "L99\n" +
                "R14\n" +
                "L82"

        const val inputStringTwo = "L68\n" +
                "L30\n" +
                "R48\n" +
                "L5\n" +
                "R60\n" +
                "L55\n" +
                "L1\n" +
                "L99\n" +
                "R14\n" +
                "L82"
    }
}