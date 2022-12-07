package days

import kotlin.system.measureTimeMillis

abstract class BaseDay(protected val input: List<String>): IDay {
    override fun solve() {
        var solutionOne = ""
        var solutionTwo = ""

        val execTimeOne = measureTimeMillis {
            solutionOne = solvePartOne()
        }
        val execTimetwo = measureTimeMillis {
            solutionTwo = solvePartTwo()
        }
        println("Part one solution=${solutionOne}, in $execTimeOne milliseconds")
        println("Part two solution=${solutionTwo}, in $execTimetwo milliseconds")
    }

    abstract override fun solvePartOne(): String
    abstract override fun solvePartTwo(): String
}