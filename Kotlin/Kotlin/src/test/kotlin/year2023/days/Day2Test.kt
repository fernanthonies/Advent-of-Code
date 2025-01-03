package year2023.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import year2023.Days.Day2

class Day2Test {
    private lateinit var subject: Day2

    @BeforeEach
    fun setUp() {
        subject = year2023.Days.Day2()
    }

    @Test
    fun solvePartOne() {
        val result = subject.solvePartOne()
        Assertions.assertEquals("8", result)
    }

    @Test
    fun solvePartTwo() {
        val result = subject.solvePartTwo()
        Assertions.assertEquals("2286", result)
    }

    private val inputString = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
                                 "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
                                 "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
                                 "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
                                 "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
}