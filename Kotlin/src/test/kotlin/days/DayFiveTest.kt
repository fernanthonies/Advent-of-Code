package days

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DayFiveTest {

    private lateinit var subject: DayFive

    @BeforeEach
    fun setUp() {
        subject = DayFive(inputString.split("\n"))
    }

    @Test
    fun solvePartOne() {
        val result = subject.solvePartOne()
        assertEquals(24000, result)
    }

    @Test
    fun solvePartTwo() {
        val result = subject.solvePartTwo()
        assertEquals(45000, result)
    }

    private val inputString = ""
}