package year2022.days

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import year2022.Days.DayTwo

class DayTwoTest {

    private lateinit var subject: DayTwo

    @BeforeEach
    fun setUp() {
        subject = DayTwo(inputString.split("\n"))
    }

    @Test
    fun solvePartOne() {
        val result = subject.solvePartOne()
        assertEquals("15", result)
    }

    @Test
    fun solvePartTwo() {
        val result = subject.solvePartTwo()
        assertEquals("12", result)
    }

    private val inputString = "A Y\n" +
            "B X\n" +
            "C Z"
}