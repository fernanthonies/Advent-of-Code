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
        subject = DayTen(inputStringTwo.split("\n"))
        val result = subject.solvePartTwo()
        Assertions.assertEquals("10", result)
    }

    private val inputString =   "7-F7-\n" +
                                ".FJ|7\n" +
                                "SJLL7\n" +
                                "|F--J\n" +
                                "LJ.LJ"

    private val inputStringTwo =    "FF7FSF7F7F7F7F7F---7\n" +
                                    "L|LJ||||||||||||F--J\n" +
                                    "FL-7LJLJ||||||LJL-77\n" +
                                    "F--JF--7||LJLJ7F7FJ-\n" +
                                    "L---JF-JLJ.||-FJLJJ7\n" +
                                    "|F|F-JF---7F7-L7L|7|\n" +
                                    "|FFJF7L7F-JF7|JL---7\n" +
                                    "7-L-JL7||F7|L7F-7F7|\n" +
                                    "L.L7LFJ|||||FJL7||LJ\n" +
                                    "L7JLJL-JLJLJL--JLJ.L"
}