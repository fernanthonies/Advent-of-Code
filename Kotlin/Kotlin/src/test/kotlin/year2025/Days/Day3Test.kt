package year2025.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day3Test: BaseTest<Day3>(inputStringOne, inputStringTwo, ::Day3) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("357", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("3121910778619", result)
    }

    private companion object {
        const val inputStringOne = "987654321111111\n" +
                "811111111111119\n" +
                "234234234234278\n" +
                "818181911112111"

        const val inputStringTwo = "987654321111111\n" +
                "811111111111119\n" +
                "234234234234278\n" +
                "818181911112111"
    }
}