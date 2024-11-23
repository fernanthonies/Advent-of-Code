package year2023.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2023.Days.DayNine

class DayNineTest {
    private lateinit var subject: DayNine

    @Test
    fun solvePartOne() {
        subject = DayNine()
        val result = subject.solvePartOne()
        Assertions.assertEquals("114", result)
    }

    @Test
    fun solvePartTwo() {
        subject = DayNine()
        val result = subject.solvePartTwo()
        Assertions.assertEquals("2", result)
    }

    private val inputString =   "0 3 6 9 12 15\n" +
                                "1 3 6 10 15 21\n" +
                                "10 13 16 21 30 45"
}