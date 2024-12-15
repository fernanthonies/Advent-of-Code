package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day13

class Day13Test: BaseTest<Day13>(inputStringOne, inputStringOne, ::Day13) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("480", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("81", result)
    }

    private companion object {
        const val inputStringOne =
                    "Button A: X+94, Y+34\n" +
                    "Button B: X+22, Y+67\n" +
                    "Prize: X=8400, Y=5400\n" +
                    "\n" +
                    "Button A: X+26, Y+66\n" +
                    "Button B: X+67, Y+21\n" +
                    "Prize: X=12748, Y=12176\n" +
                    "\n" +
                    "Button A: X+17, Y+86\n" +
                    "Button B: X+84, Y+37\n" +
                    "Prize: X=7870, Y=6450\n" +
                    "\n" +
                    "Button A: X+69, Y+23\n" +
                    "Button B: X+27, Y+71\n" +
                    "Prize: X=18641, Y=10279"
    }
}