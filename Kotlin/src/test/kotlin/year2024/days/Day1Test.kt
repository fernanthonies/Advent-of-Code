package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day1

class Day1Test: BaseTest<Day1>(inputStringOne, inputStringTwo, ::Day1) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("", result)
    }

    private companion object {
        const val inputStringOne = ""

        const val inputStringTwo = ""
    }
}