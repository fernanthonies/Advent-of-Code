package year2025.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day7Test: BaseTest<Day7>(inputStringOne, inputStringOne, ::Day7) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("21", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("40", result)
    }

    private companion object {
        const val inputStringOne =
                        ".......S.......\n" +
                        "...............\n" +
                        ".......^.......\n" +
                        "...............\n" +
                        "......^.^......\n" +
                        "...............\n" +
                        ".....^.^.^.....\n" +
                        "...............\n" +
                        "....^.^...^....\n" +
                        "...............\n" +
                        "...^.^...^.^...\n" +
                        "...............\n" +
                        "..^...^.....^..\n" +
                        "...............\n" +
                        ".^.^.^.^.^...^.\n" +
                        "..............."
    }
}