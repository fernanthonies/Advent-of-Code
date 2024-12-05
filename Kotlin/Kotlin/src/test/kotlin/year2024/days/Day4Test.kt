package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day4

class Day4Test: BaseTest<Day4>(inputStringOne, inputStringTwo, ::Day4) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("18", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("9", result)
    }

    private companion object {
        const val inputStringOne = "MMMSXXMASM\n" +
                                    "MSAMXMSMSA\n" +
                                    "AMXSXMAAMM\n" +
                                    "MSAMASMSMX\n" +
                                    "XMASAMXAMM\n" +
                                    "XXAMMXXAMA\n" +
                                    "SMSMSASXSS\n" +
                                    "SAXAMASAAA\n" +
                                    "MAMMMXMMMM\n" +
                                    "MXMXAXMASX"

        const val inputStringTwo = "MMMSXXMASM\n" +
                                    "MSAMXMSMSA\n" +
                                    "AMXSXMAAMM\n" +
                                    "MSAMASMSMX\n" +
                                    "XMASAMXAMM\n" +
                                    "XXAMMXXAMA\n" +
                                    "SMSMSASXSS\n" +
                                    "SAXAMASAAA\n" +
                                    "MAMMMXMMMM\n" +
                                    "MXMXAXMASX"
    }
}