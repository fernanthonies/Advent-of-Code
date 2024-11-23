package year2021.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Test: BaseTest<Day1>(inputStringOne, inputStringTwo, ::Day1) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("7", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("5", result)
    }

    private companion object {
        const val inputStringOne = "199\n" +
                                    "200\n" +
                                    "208\n" +
                                    "210\n" +
                                    "200\n" +
                                    "207\n" +
                                    "240\n" +
                                    "269\n" +
                                    "260\n" +
                                    "263"

        const val inputStringTwo = "199\n" +
                                    "200\n" +
                                    "208\n" +
                                    "210\n" +
                                    "200\n" +
                                    "207\n" +
                                    "240\n" +
                                    "269\n" +
                                    "260\n" +
                                    "263"
    }
}