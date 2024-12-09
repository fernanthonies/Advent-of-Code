package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day8

class Day8Test: BaseTest<Day8>(inputStringOne, inputStringOne, ::Day8) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("14", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("34", result)
    }

    private companion object {
        const val inputStringOne =
            "............\n" +
            "........0...\n" +
            ".....0......\n" +
            ".......0....\n" +
            "....0.......\n" +
            "......A.....\n" +
            "............\n" +
            "............\n" +
            "........A...\n" +
            ".........A..\n" +
            "............\n" +
            "............"
    }
}