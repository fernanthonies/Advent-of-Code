package days

interface IDay {
    fun setData(data: List<String>)
    fun solve()
    fun solvePartOne(): String
    fun solvePartTwo(): String
}