package year2023.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import year2023.Days.DaySix

class DaySixTest {
    private lateinit var subject: DaySix

    @BeforeEach
    fun setUp() {
        subject = DaySix(inputString.split("\n"))
    }

    @Test
    fun solvePartOne() {
        val result = subject.solvePartOne()
        Assertions.assertEquals("288", result)
    }

    @Test
    fun solvePartTwo() {
        val result = subject.solvePartTwo()
        Assertions.assertEquals("71503", result)
    }

    private val inputString =   "Time:      7  15   30\n" +
                                "Distance:  9  40  200"
}