package year2022.days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import year2022.Days.DayOne

class Day1Test {

    private lateinit var subject: DayOne

    @BeforeEach
    fun setUp() {
        subject = DayOne()
        subject.setData(inputString.split("\n"))
    }

    @Test
    fun solvePartOne() {
        val result = subject.solvePartOne()
        assertEquals("24000", result)
    }

    @Test
    fun solvePartTwo() {
        val result = subject.solvePartTwo()
        assertEquals("45000", result)
    }

    private val inputString = "1000\n" +
            "2000\n" +
            "3000\n" +
            "\n" +
            "4000\n" +
            "\n" +
            "5000\n" +
            "6000\n" +
            "\n" +
            "7000\n" +
            "8000\n" +
            "9000\n" +
            "\n" +
            "10000\n"
}