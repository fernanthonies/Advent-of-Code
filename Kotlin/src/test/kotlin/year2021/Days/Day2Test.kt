package year2021.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2021.Days.Day2

class Day2Test: BaseTest<year2021.Days.Day2>(inputStringOne, inputStringTwo, ::Day2) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("150", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("900", result)
    }

    private companion object {
        const val inputStringOne = "forward 5\n" +
                "down 5\n" +
                "forward 8\n" +
                "up 3\n" +
                "down 8\n" +
                "forward 2"

        const val inputStringTwo = "forward 5\n" +
                "down 5\n" +
                "forward 8\n" +
                "up 3\n" +
                "down 8\n" +
                "forward 2"
    }
}