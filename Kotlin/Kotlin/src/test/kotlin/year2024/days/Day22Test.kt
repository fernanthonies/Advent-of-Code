package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day16
import year2024.Days.Day18
import year2024.Days.Day19

class Day22Test: BaseTest<Day19>(inputStringOne, inputStringTwo, ::Day19) {

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