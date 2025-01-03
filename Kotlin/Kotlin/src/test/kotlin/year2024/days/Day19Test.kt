package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day16
import year2024.Days.Day18
import year2024.Days.Day19

class Day19Test: BaseTest<Day19>(inputStringOne, inputStringTwo, ::Day19) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("6", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("", result)
    }

    private companion object {
        const val inputStringOne = "r, wr, b, g, bwu, rb, gb, br\n" +
                "\n" +
                "brwrr\n" +
                "bggr\n" +
                "gbbr\n" +
                "rrbgbr\n" +
                "ubwu\n" +
                "bwurrg\n" +
                "brgr\n" +
                "bbrgwb"

        const val inputStringTwo = ""
    }
}