package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day9

class Day9Test: BaseTest<Day9>(inputStringOne, inputStringOne, ::Day9) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("1928", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("2858", result)
    }

    private companion object {
        const val inputStringOne = "2333133121414131402"
    }
}