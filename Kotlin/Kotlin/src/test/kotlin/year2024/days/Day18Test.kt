package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day16
import year2024.Days.Day18

class Day18Test: BaseTest<Day18>(inputStringOne, inputStringTwo, ::Day18) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("22", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("", result)
    }

    private companion object {
        const val inputStringOne =
                        "5,4\n" +
                        "4,2\n" +
                        "4,5\n" +
                        "3,0\n" +
                        "2,1\n" +
                        "6,3\n" +
                        "2,4\n" +
                        "1,5\n" +
                        "0,6\n" +
                        "3,3\n" +
                        "2,6\n" +
                        "5,1\n" +
                        "1,2\n" +
                        "5,5\n" +
                        "2,5\n" +
                        "6,5\n" +
                        "1,4\n" +
                        "0,4\n" +
                        "6,4\n" +
                        "1,1\n" +
                        "6,1\n" +
                        "1,0\n" +
                        "0,5\n" +
                        "1,6\n" +
                        "2,0\n"

        const val inputStringTwo =
                "###############\n" +
                "#.......#....E#\n" +
                "#.#.###.#.###.#\n" +
                "#.....#.#...#.#\n" +
                "#.###.#####.#.#\n" +
                "#.#.#.......#.#\n" +
                "#.#.#####.###.#\n" +
                "#...........#.#\n" +
                "###.#.#####.#.#\n" +
                "#...#.....#.#.#\n" +
                "#.#.#.###.#.#.#\n" +
                "#.....#...#.#.#\n" +
                "#.###.#.#.#.#.#\n" +
                "#S..#.....#...#\n" +
                "###############"
    }
}