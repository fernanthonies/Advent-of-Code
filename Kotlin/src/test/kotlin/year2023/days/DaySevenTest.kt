package year2023.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import year2023.Days.DaySeven

class DaySevenTest {
    private lateinit var subject: DaySeven

    @BeforeEach
    fun setUp() {
        subject = DaySeven()
    }

    @Test
    fun solvePartOne() {
        val result = subject.solvePartOne()
        Assertions.assertEquals("6440", result)
    }

    @Test
    fun solvePartTwo() {
        val result = subject.solvePartTwo()
        Assertions.assertEquals("5905", result)
    }

    @Test
    fun testGetStrength() {
        Assertions.assertEquals(1, subject.getStrength("12345"))
        Assertions.assertEquals(2, subject.getStrength("AA345"))
        Assertions.assertEquals(3, subject.getStrength("JJKK2"))
        Assertions.assertEquals(4, subject.getStrength("TTT98"))
        Assertions.assertEquals(5, subject.getStrength("KKK77"))
        Assertions.assertEquals(6, subject.getStrength("QQQQA"))
        Assertions.assertEquals(7, subject.getStrength("AAAAA"))
    }

    private val inputString =   "32T3K 765\n" +
                                "T55J5 684\n" +
                                "KK677 28\n" +
                                "KTJJT 220\n" +
                                "QQQJA 483"
}