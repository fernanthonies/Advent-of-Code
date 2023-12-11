package year2023.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2023.Days.DayEleven
import year2023.Days.DayNine
import year2023.Days.DayTen

class DayElevenTest {
    private lateinit var subject: DayEleven

    @Test
    fun solvePartOne() {
        subject = DayEleven(inputString.split("\n"))
        val result = subject.solvePartOne()
        Assertions.assertEquals("374", result)
    }

    @Test
    fun solvePartTwo() {
        subject = DayEleven(inputStringTwo.split("\n"))
        val result = subject.solvePartTwo()
        Assertions.assertEquals("10", result)
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