package year2023.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2023.Days.DayTwelve

class DayTwelveTest {
    private lateinit var subject: DayTwelve
    @Test
    fun solvePartOne() {
        subject = DayTwelve()
        subject.setData(inputString.split("\n"))
        val result = subject.solvePartOne()
        Assertions.assertEquals("21", result)
    }

    @Test
    fun solvePartTwo() {
        subject = DayTwelve()
        subject.setData(inputString.split("\n"))
        val result = subject.solvePartTwo()
        Assertions.assertEquals("8410", result)
    }

    private val inputString =   "???.### 1,1,3\n" +
                                ".??..??...?##. 1,1,3\n" +
                                "?#?#?#?#?#?#?#? 1,3,1,6\n" +
                                "????.#...#... 4,1,1\n" +
                                "????.######..#####. 1,6,5\n" +
                                "?###???????? 3,2,1"
}