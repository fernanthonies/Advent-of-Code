
import days.IDay
import kotlin.system.measureTimeMillis

abstract class BaseDay(): IDay {
    protected var input: List<String> = listOf()

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

    override fun setData(data: List<String>) {
        input = data
    }
    abstract override fun solvePartOne(): String
    abstract override fun solvePartTwo(): String
}