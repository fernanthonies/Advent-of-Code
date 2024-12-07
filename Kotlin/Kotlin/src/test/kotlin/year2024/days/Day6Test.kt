package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day6

class Day6Test: BaseTest<Day6>(inputStringOne, inputStringOne, ::Day6) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("41", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("6", result)
    }

    private companion object {
        const val inputStringOne = "....#.....\n" +
                                    ".........#\n" +
                                    "..........\n" +
                                    "..#.......\n" +
                                    ".......#..\n" +
                                    "..........\n" +
                                    ".#..^.....\n" +
                                    "........#.\n" +
                                    "#.........\n" +
                                    "......#..."
    }
}