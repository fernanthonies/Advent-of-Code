package year2023.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import year2023.Days.DayThree

class DayThreeTest {
    private lateinit var subject: DayThree

    @BeforeEach
    fun setUp() {
        subject = DayThree(inputString.split("\n"))
    }

    @Test
    fun solvePartOne() {
        val result = subject.solvePartOne()
        Assertions.assertEquals("4361", result)
    }

    @Test
    fun solvePartTwo() {
        val result = subject.solvePartTwo()
        Assertions.assertEquals("467835", result)
    }

    private val inputString = "467..114..\n" +
            "...*......\n" +
            "..35..633.\n" +
            "......#...\n" +
            "617*......\n" +
            ".....+.58.\n" +
            "..592.....\n" +
            "......755.\n" +
            "...\$.*....\n" +
            ".664.598.."
}