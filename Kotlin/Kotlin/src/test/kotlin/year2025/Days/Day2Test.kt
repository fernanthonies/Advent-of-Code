package year2025.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day2Test: BaseTest<Day2>(inputStringOne, inputStringTwo, ::Day2) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("1227775554", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("4174379265", result)
    }

    private companion object {
        const val inputStringOne = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                "824824821-824824827,2121212118-2121212124"

        const val inputStringTwo = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                "824824821-824824827,2121212118-2121212124"
    }
}