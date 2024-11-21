package year2023.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import year2023.Days.DayFive
import year2023.Days.Mapping

class DayFiveTest {
    private lateinit var subject: DayFive

    @BeforeEach
    fun setUp() {
        subject = DayFive(inputString.split("\n"))
    }

    @Test
    fun solvePartOne() {
        val result = subject.solvePartOne()
        Assertions.assertEquals("35", result)
    }

    @Test
    fun solvePartTwo() {
        val result = subject.solvePartTwo()
        Assertions.assertEquals("46", result)
    }

    @Test
    fun testMapping() {
        val mapping = Mapping(98, 50, 2)
        Assertions.assertEquals(50, mapping.mapValue(98))
        Assertions.assertEquals(51, mapping.mapValue(99))
        Assertions.assertEquals(100, mapping.mapValue(100))
        Assertions.assertEquals(15, mapping.mapValue(15))
    }

    @Test
    fun testRangeMapping() {
        val mapping = Mapping(20, 40, 10)
        var result = mapping.mapRange(Pair(25, 28))
        Assertions.assertEquals(45, result.first?.first)
        Assertions.assertEquals(48, result.first?.second)
        Assertions.assertEquals(0, result.second.count())

        result = mapping.mapRange(Pair(25, 35))
        Assertions.assertEquals(45, result.first?.first)
        Assertions.assertEquals(49, result.first?.second)
        Assertions.assertEquals(1, result.second.count())

        result = mapping.mapRange(Pair(15, 25))
        Assertions.assertEquals(40, result.first?.first)
        Assertions.assertEquals(45, result.first?.second)
        Assertions.assertEquals(1, result.second.count())

        result = mapping.mapRange(Pair(30, 40))
        Assertions.assertNull(result.first)
        Assertions.assertEquals(1, result.second.count())

        result = mapping.mapRange(Pair(10, 15))
        Assertions.assertNull(result.first)
        Assertions.assertEquals(1, result.second.count())

        result = mapping.mapRange(Pair(15, 35))
        Assertions.assertEquals(40, result.first?.first)
        Assertions.assertEquals(49, result.first?.second)
        Assertions.assertEquals(2, result.second.count())
    }

    private val inputString = "seeds: 79 14 55 13\n" +
            "\n" +
            "seed-to-soil map:\n" +
            "50 98 2\n" +
            "52 50 48\n" +
            "\n" +
            "soil-to-fertilizer map:\n" +
            "0 15 37\n" +
            "37 52 2\n" +
            "39 0 15\n" +
            "\n" +
            "fertilizer-to-water map:\n" +
            "49 53 8\n" +
            "0 11 42\n" +
            "42 0 7\n" +
            "57 7 4\n" +
            "\n" +
            "water-to-light map:\n" +
            "88 18 7\n" +
            "18 25 70\n" +
            "\n" +
            "light-to-temperature map:\n" +
            "45 77 23\n" +
            "81 45 19\n" +
            "68 64 13\n" +
            "\n" +
            "temperature-to-humidity map:\n" +
            "0 69 1\n" +
            "1 0 69\n" +
            "\n" +
            "humidity-to-location map:\n" +
            "60 56 37\n" +
            "56 93 4"
}