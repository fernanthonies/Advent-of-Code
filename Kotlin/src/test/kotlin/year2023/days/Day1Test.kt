package year2023.days

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import year2023.Days.Day1

class Day1Test {

    private lateinit var subject: Day1

    @Test
    fun solvePartOne() {
        subject = Day1(inputStringOne.split("\n"))
        val result = subject.solvePartOne()
        assertEquals("142", result)
    }

    @Test
    fun solvePartTwo() {
        subject = Day1(inputStringTwo.split("\n"))
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