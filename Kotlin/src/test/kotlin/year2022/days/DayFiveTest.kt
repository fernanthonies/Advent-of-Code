package year2022.days

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import year2022.Days.DayFive
import java.util.*

class DayFiveTest {

    private lateinit var subject: DayFive

    @BeforeEach
    fun setUp() {
        subject = DayFive(inputString.split("\n"))
    }

    @Test
    fun solvePartOne() {
        val result = subject.solvePartOne()
        assertEquals("CMZ", result)
    }

    @Test
    fun solvePartTwo() {
        val result = subject.solvePartTwo()
        assertEquals("MCD", result)
    }

    @Test
    fun parseStacks() {
        val stacks = subject.parseStacks(stackString.split("\n").dropLast(1))
        val firstStack = stacks[0]
        assertEquals(2, firstStack.count())
        assertEquals('N', firstStack.pop())
        assertEquals('Z', firstStack.pop())

        val secondStack = stacks[1]
        assertEquals(3, secondStack.count())
        assertEquals('D', secondStack.pop())
        assertEquals('C', secondStack.pop())
        assertEquals('M', secondStack.pop())

        val thirdStack = stacks[2]
        assertEquals(1, thirdStack.count())
        assertEquals('P', thirdStack.pop())
    }

    @Test
    fun parseInstructionLine() {
        val input = "move 1 from 2 to 1"
        val result = subject.parseInstructionLine(input)

        assertEquals(1, result.first)
        assertEquals(2, result.second)
        assertEquals(1, result.third)
    }

    @Test
    fun perform9000Move() {
        val stacks = listOf(LinkedList<Char>(), LinkedList<Char>())
        stacks[0].push('A')
        stacks[0].push('B')
        stacks[0].push('C')
        val instruction = Triple(3, 1, 2)

        subject.perform9000Move(instruction, stacks)

        assertTrue(stacks[0].isEmpty())
        assertEquals(3, stacks[1].count())
        assertEquals("[A, B, C]", stacks[1].toString())
    }

    @Test
    fun perform9001Move() {
        val stacks = listOf(LinkedList<Char>(), LinkedList<Char>())
        stacks[0].push('A')
        stacks[0].push('B')
        stacks[0].push('C')
        val instruction = Triple(3, 1, 2)

        subject.perform9001Move(instruction, stacks)

        assertTrue(stacks[0].isEmpty())
        assertEquals(3, stacks[1].count())
        assertEquals("[C, B, A]", stacks[1].toString())
    }

    private val inputString = "    [D]    \n" +
            "[N] [C]    \n" +
            "[Z] [M] [P]\n" +
            " 1   2   3 \n" +
            "\n" +
            "move 1 from 2 to 1\n" +
            "move 3 from 1 to 3\n" +
            "move 2 from 2 to 1\n" +
            "move 1 from 1 to 2"

    private val stackString = "    [D]    \n" +
            "[N] [C]    \n" +
            "[Z] [M] [P]\n"
}