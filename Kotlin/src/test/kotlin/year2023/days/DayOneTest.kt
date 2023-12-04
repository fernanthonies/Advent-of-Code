package year2023.days

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import year2023.Days.DayOne

class DayOneTest {

    private lateinit var subject: DayOne

    @Test
    fun solvePartOne() {
        subject = DayOne(inputStringOne.split("\n"))
        val result = subject.solvePartOne()
        assertEquals("142", result)
    }

    @Test
    fun solvePartTwo() {
        subject = DayOne(inputStringTwo.split("\n"))
        val result = subject.solvePartTwo()
        assertEquals("281", result)
    }

    private val inputStringOne = "1abc2\n" +
            "pqr3stu8vwx\n" +
            "a1b2c3d4e5f\n" +
            "treb7uchet"

    private val inputStringTwo = "two1nine\n" +
            "eightwothree\n" +
            "abcone2threexyz\n" +
            "xtwone3four\n" +
            "4nineeightseven2\n" +
            "zoneight234\n" +
            "7pqrstsixteen"
}