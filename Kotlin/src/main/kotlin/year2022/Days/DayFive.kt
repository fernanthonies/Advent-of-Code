package year2022.Days

import BaseDay
import java.util.*

class DayFive(input: List<String>) : BaseDay(input) {
    override fun solvePartOne(): String {
        return runInstructionList { instruction, stackList -> perform9000Move(instruction, stackList) }
    }

    override fun solvePartTwo(): String {
        return runInstructionList { instruction, stackList -> perform9001Move(instruction, stackList) }
    }

    private fun runInstructionList(moveMethod: (instruction: Triple<Int, Int, Int>, stackList: List<Deque<Char>>) -> Unit): String {
        val breakLine = input.indexOfFirst { it.isBlank() }
        val stackList = parseStacks(input.subList(0, breakLine-1))
        val instructionList = input.subList(breakLine + 1, input.count())

        var result = ""

        instructionList.forEach { instruction ->
            moveMethod(parseInstructionLine(instruction), stackList)
        }

        stackList.forEach { stack ->
            result += stack.pop()
        }

        return result
    }

    fun perform9000Move(instruction: Triple<Int, Int, Int>, stackList: List<Deque<Char>>) {
        for(i in 1..instruction.first) {
            val crate = stackList[instruction.second - 1].pop()
            stackList[instruction.third - 1].push(crate)
        }
    }

    fun perform9001Move(instruction: Triple<Int, Int, Int>, stackList: List<Deque<Char>>) {
        val tempStack = LinkedList<Char>()
        for(i in 1..instruction.first) {
            tempStack.add(stackList[instruction.second - 1].pop())
        }

        do {
            stackList[instruction.third - 1].push(tempStack.removeLast())
        } while (!tempStack.isEmpty())
    }

    fun parseStacks(input: List<String>): List<Deque<Char>> {
        val result = mutableListOf<Deque<Char>>()
        val stackLines = input.map { it.toList().chunked(4).map { chunk -> chunk[1] } }.reversed()
        val stackCount = stackLines.first().count()

        for (i in 1..stackCount) {
            result.add(LinkedList())
        }

        stackLines.forEach { line ->
            line.forEachIndexed { index, c ->
                if (c.isLetter()) {
                    result[index].push(c)
                }
            }
        }
        return result
    }

    fun parseInstructionLine(input: String): Triple<Int, Int, Int> {
        val splitInput = input.split(" ")
        return Triple(splitInput[1].toInt(), splitInput[3].toInt(), splitInput[5].toInt())
    }
}