package year2025.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day9Test: BaseTest<Day9>(inputStringOne, inputStringOne, ::Day9) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("50", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("24", result)
    }

    private companion object {
        const val inputStringOne =  "7,1\n" +
                                    "11,1\n" +
                                    "11,7\n" +
                                    "9,7\n" +
                                    "9,5\n" +
                                    "2,5\n" +
                                    "2,3\n" +
                                    "7,3"
    }
}