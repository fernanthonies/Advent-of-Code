package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day3

class Day3Test: BaseTest<Day3>(inputStringOne, inputStringTwo, ::Day3) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("161", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("48", result)
    }

    private companion object {
        const val inputStringOne = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"

        const val inputStringTwo = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
    }
}