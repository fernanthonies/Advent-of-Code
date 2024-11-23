package year2023.days

import BaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import year2023.Days.Day1

class Day1Test: BaseTest<Day1>(inputStringOne, inputStringTwo, ::Day1) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        assertEquals("142", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        assertEquals("281", result)
    }

    private companion object {
        const val inputStringOne = "1abc2\n" +
                "pqr3stu8vwx\n" +
                "a1b2c3d4e5f\n" +
                "treb7uchet"

        const val inputStringTwo = "two1nine\n" +
                "eightwothree\n" +
                "abcone2threexyz\n" +
                "xtwone3four\n" +
                "4nineeightseven2\n" +
                "zoneight234\n" +
                "7pqrstsixteen"
    }
}