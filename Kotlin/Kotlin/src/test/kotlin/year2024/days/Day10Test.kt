package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day10

class Day10Test: BaseTest<Day10>(inputStringOne, inputStringOne, ::Day10) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("36", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("81", result)
    }

    private companion object {
        const val inputStringOne =
                "89010123\n" +
                "78121874\n" +
                "87430965\n" +
                "96549874\n" +
                "45678903\n" +
                "32019012\n" +
                "01329801\n" +
                "10456732"
    }
}