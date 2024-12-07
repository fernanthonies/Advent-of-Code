package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day7

class Day7Test: BaseTest<Day7>(inputStringOne, inputStringOne, ::Day7) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("3749", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("11387", result)
    }

    private companion object {
        const val inputStringOne =
                "190: 10 19\n" +
                "3267: 81 40 27\n" +
                "83: 17 5\n" +
                "156: 15 6\n" +
                "7290: 6 8 6 15\n" +
                "161011: 16 10 13\n" +
                "192: 17 8 14\n" +
                "21037: 9 7 18 13\n" +
                "292: 11 6 16 20"
    }
}