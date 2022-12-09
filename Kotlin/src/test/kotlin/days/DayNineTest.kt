package days

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DayNineTest {

    private lateinit var subject: DayNine

    @Test
    fun solvePartOne() {
        subject = DayNine(inputString.split("\n"))
        assertEquals("13", subject.solvePartOne())
    }

    @Test
    fun solvePartTwo() {
        subject = DayNine(inputTwo.split("\n"))
        assertEquals("36", subject.solvePartTwo())
    }

    private val inputString = "R 4\n" +
            "U 4\n" +
            "L 3\n" +
            "D 1\n" +
            "R 4\n" +
            "D 1\n" +
            "L 5\n" +
            "R 2"

    private val inputTwo = "R 5\n" +
            "U 8\n" +
            "L 8\n" +
            "D 3\n" +
            "R 17\n" +
            "D 10\n" +
            "L 25\n" +
            "U 20"
}