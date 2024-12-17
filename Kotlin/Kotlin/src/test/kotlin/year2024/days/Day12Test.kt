package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day12

class Day12Test: BaseTest<Day12>(inputStringOne, inputStringOne, ::Day12) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("1930", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("81", result)
    }

    private companion object {
        const val inputStringOne =
                "RRRRIICCFF\n" +
                "RRRRIICCCF\n" +
                "VVRRRCCFFF\n" +
                "VVRCCCJFFF\n" +
                "VVVVCJJCFE\n" +
                "VVIVCCJJEE\n" +
                "VVIIICJJEE\n" +
                "MIIIIIJJEE\n" +
                "MIIISIJEEE\n" +
                "MMMISSJEEE"
    }
}