package year2023.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2023.Days.DayEleven

class DayElevenTest {
    private lateinit var subject: DayEleven

    @Test
    fun solvePartOne() {
        subject = DayEleven()
        val result = subject.solvePartOne()
        Assertions.assertEquals("374", result)
    }

    @Test
    fun solvePartTwo() {
        subject = DayEleven()
        val result = subject.solvePartTwo()
        Assertions.assertEquals("8410", result)
    }

    private val inputString =   "...#......\n" +
                                ".......#..\n" +
                                "#.........\n" +
                                "..........\n" +
                                "......#...\n" +
                                ".#........\n" +
                                ".........#\n" +
                                "..........\n" +
                                ".......#..\n" +
                                "#...#....."
}