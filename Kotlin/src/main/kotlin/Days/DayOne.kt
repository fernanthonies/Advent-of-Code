package days

class DayOne(input: List<String>) : BaseDay(input) {

    private val solvedList: List<Int>

    init {
        solvedList = calculateList(input)
    }

    override fun solvePartOne(): String {
        return solvedList.last().toString()
    }

    override fun solvePartTwo(): String {
        return solvedList.takeLast(3).sum().toString()
    }

    private fun calculateList(input: List<String>): List<Int> {
        val sumList = mutableListOf<Int>()
        var tempTotal = 0

        input.forEach { line ->
            line.toIntOrNull()?.let {
                tempTotal += it
            }?:run {
                sumList.add(tempTotal)
                tempTotal = 0
            }
        }

        sumList.sort()
        return sumList
    }
}