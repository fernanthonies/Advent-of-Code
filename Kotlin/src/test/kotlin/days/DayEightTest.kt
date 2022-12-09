package days

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DayEightTest {

    private lateinit var subject: DayEight

    @BeforeEach
    fun setUp() {
        subject = DayEight(inputString.split("\n"))
    }

    @Test
    fun solvePartOne() {
        assertEquals("21", subject.solvePartOne())
    }

    @Test
    fun solvePartTwo() {
        assertEquals("8", subject.solvePartTwo())
    }

    private val inputString = "30373\n" +
            "25512\n" +
            "65332\n" +
            "33549\n" +
            "35390"
}