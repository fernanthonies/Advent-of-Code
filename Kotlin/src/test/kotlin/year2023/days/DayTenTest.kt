package year2023.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2023.Days.DayNine
import year2023.Days.DayTen

class DayTenTest {
    private lateinit var subject: DayTen

    @Test
    fun solvePartOne() {
        subject = DayTen(inputString.split("\n"))
        val result = subject.solvePartOne()
        Assertions.assertEquals("8", result)
    }

    @Test
    fun solvePartTwo() {
        subject = DayTen(inputString.split("\n"))
        val result = subject.solvePartTwo()
        Assertions.assertEquals("2", result)
    }

    @Test
    fun pipeConnection() {
        Assertions.assertTrue(DayTen.PipeType.`|`.doesConnect(DayTen.PipeType.`|`))
        Assertions.assertTrue(DayTen.PipeType.`-`.doesConnect(DayTen.PipeType.`-`))
        Assertions.assertTrue(DayTen.PipeType.L.doesConnect(DayTen.PipeType.`7`))
        Assertions.assertTrue(DayTen.PipeType.F.doesConnect(DayTen.PipeType.J))

        Assertions.assertFalse(DayTen.PipeType.`-`.doesConnect(DayTen.PipeType.`|`))
        Assertions.assertFalse(DayTen.PipeType.J.doesConnect(DayTen.PipeType.J))
    }

    private val inputString =   "7-F7-\n" +
                                ".FJ|7\n" +
                                "SJLL7\n" +
                                "|F--J\n" +
                                "LJ.LJ"
}