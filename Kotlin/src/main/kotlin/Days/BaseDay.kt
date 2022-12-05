package days

abstract class BaseDay(protected val input: List<String>): IDay {
    override fun solve() {
        println("Part one solution=${solvePartOne()}")
        println("Part two solution=${solvePartTwo()}")
    }

    abstract override fun solvePartOne(): Int
    abstract override fun solvePartTwo(): Int
}