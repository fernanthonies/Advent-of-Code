package year2023.days

import common.lcm
import common.lcmOfArray
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import year2023.Days.DayEight
import year2023.Days.DaySeven
import year2023.Days.DaySix

class DayEightTest {
    private lateinit var subject: DayEight

    @Test
    fun solvePartOne() {
        subject = DayEight(inputStringOne.split("\n"))
        val result = subject.solvePartOne()
        Assertions.assertEquals("6", result)
    }

    @Test
    fun solvePartTwo() {
        subject = DayEight(inputStringTwo.split("\n"))
        val result = subject.solvePartTwo()
        Assertions.assertEquals("6", result)
    }

    private val inputStringOne =   "LLR\n" +
                                    "\n" +
                                    "AAA = (BBB, BBB)\n" +
                                    "BBB = (AAA, ZZZ)\n" +
                                    "ZZZ = (ZZZ, ZZZ)"

    private val inputStringTwo =   "LR\n" +
                                    "\n" +
                                    "11A = (11B, XXX)\n" +
                                    "11B = (XXX, 11Z)\n" +
                                    "11Z = (11B, XXX)\n" +
                                    "22A = (22B, XXX)\n" +
                                    "22B = (22C, 22C)\n" +
                                    "22C = (22Z, 22Z)\n" +
                                    "22Z = (22B, 22B)\n" +
                                    "XXX = (XXX, XXX)"
}