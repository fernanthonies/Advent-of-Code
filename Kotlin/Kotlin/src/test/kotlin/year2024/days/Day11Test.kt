package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day11

class Day11Test: BaseTest<Day11>(inputStringOne, inputStringOne, ::Day11) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("55312", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("81", result)
    }

    private companion object {
        const val inputStringOne = "125 17"
    }
}