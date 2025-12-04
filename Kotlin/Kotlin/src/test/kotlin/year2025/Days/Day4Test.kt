package year2025.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day4Test: BaseTest<Day4>(inputStringOne, inputStringTwo, ::Day4) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("13", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("43", result)
    }

    private companion object {
        const val inputStringOne =  "..@@.@@@@.\n" +
                                    "@@@.@.@.@@\n" +
                                    "@@@@@.@.@@\n" +
                                    "@.@@@@..@.\n" +
                                    "@@.@@@@.@@\n" +
                                    ".@@@@@@@.@\n" +
                                    ".@.@.@.@@@\n" +
                                    "@.@@@.@@@@\n" +
                                    ".@@@@@@@@.\n" +
                                    "@.@.@@@.@."

        const val inputStringTwo =  "..@@.@@@@.\n" +
                                    "@@@.@.@.@@\n" +
                                    "@@@@@.@.@@\n" +
                                    "@.@@@@..@.\n" +
                                    "@@.@@@@.@@\n" +
                                    ".@@@@@@@.@\n" +
                                    ".@.@.@.@@@\n" +
                                    "@.@@@.@@@@\n" +
                                    ".@@@@@@@@.\n" +
                                    "@.@.@@@.@."
    }
}