package year2025.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day6Test: BaseTest<Day6>(inputStringOne, inputStringOne, ::Day6) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("4277556", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("3263827", result)
    }

    private companion object {
        const val inputStringOne =  "123 328  51 64 \n" +
                                    " 45 64  387 23 \n" +
                                    "  6 98  215 314\n" +
                                    "*   +   *   +  "
    }
}