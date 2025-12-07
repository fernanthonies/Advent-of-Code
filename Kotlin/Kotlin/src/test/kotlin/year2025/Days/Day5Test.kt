package year2025.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day5Test: BaseTest<Day5>(inputStringOne, inputStringOne, ::Day5) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("3", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("14", result)
    }

    private companion object {
        const val inputStringOne = "3-5\n" +
                "10-14\n" +
                "16-20\n" +
                "12-18\n" +
                "\n" +
                "1\n" +
                "5\n" +
                "8\n" +
                "11\n" +
                "17\n" +
                "32"
    }
}