package year2025.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day12Test: BaseTest<Day12>(inputStringOne, inputStringTwo, ::Day12) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("2", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("368", result)
    }

    private companion object {
        const val inputStringOne =
                        "0:\n" +
                        "###\n" +
                        "##.\n" +
                        "##.\n" +
                        "\n" +
                        "1:\n" +
                        "###\n" +
                        "##.\n" +
                        ".##\n" +
                        "\n" +
                        "2:\n" +
                        ".##\n" +
                        "###\n" +
                        "##.\n" +
                        "\n" +
                        "3:\n" +
                        "##.\n" +
                        "###\n" +
                        "##.\n" +
                        "\n" +
                        "4:\n" +
                        "###\n" +
                        "#..\n" +
                        "###\n" +
                        "\n" +
                        "5:\n" +
                        "###\n" +
                        ".#.\n" +
                        "###\n" +
                        "\n" +
                        "4x4: 0 0 0 0 2 0\n" +
                        "12x5: 1 0 1 0 2 2\n" +
                        "12x5: 1 0 1 0 3 2"

        const val inputStringTwo =
                "AAAAAA\n" +
                        "AAABBA\n" +
                        "AAABBA\n" +
                        "ABBAAA\n" +
                        "ABBAAA\n" +
                        "AAAAAA\n"
    }
}