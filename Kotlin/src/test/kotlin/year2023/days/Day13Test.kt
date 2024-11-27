package year2023.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2023.Days.Day13

class Day13Test: BaseTest<Day13>(inputStringOne, inputStringTwo, ::Day13) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("405", result)
    }

    @Test
    fun solvePartTwo() {
        testPartOne()
        val result = testPartTwo()
        Assertions.assertEquals("400", result)
    }

    private companion object {
        const val inputStringOne = "#.##..##.\n" +
                                    "..#.##.#.\n" +
                                    "##......#\n" +
                                    "##......#\n" +
                                    "..#.##.#.\n" +
                                    "..##..##.\n" +
                                    "#.#.##.#.\n" +
                                    "\n" +
                                    "#...##..#\n" +
                                    "#....#..#\n" +
                                    "..##..###\n" +
                                    "#####.##.\n" +
                                    "#####.##.\n" +
                                    "..##..###\n" +
                                    "#....#..#"

        const val inputStringTwo = inputStringOne
    }
}