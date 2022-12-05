package days

class DayFour(input: List<String>) : BaseDay(input) {
    override fun solvePartOne(): Int {
        var containsTotal = 0

        input.forEach {line ->
            val elfOne = line.split(",")[0].split("-").let{ it[0].toInt() to it[1].toInt()}
            val elfTwo = line.split(",")[1].split("-").let{ it[0].toInt() to it[1].toInt()}

            if (elfOne.contains(elfTwo) || elfTwo.contains(elfOne)) {
                containsTotal++
            }
        }

        return containsTotal
    }

    override fun solvePartTwo(): Int {
        var overlapsTotal = 0

        input.forEach {line ->
            val elfOne = line.split(",")[0].split("-").let{ it[0].toInt() to it[1].toInt()}
            val elfTwo = line.split(",")[1].split("-").let{ it[0].toInt() to it[1].toInt()}

            if (elfOne.intersects(elfTwo) || elfTwo.intersects(elfOne)) {
                overlapsTotal++
            }
        }

        return overlapsTotal
    }

    fun Pair<Int, Int>.contains(other: Pair<Int, Int>): Boolean {
        return this.first <= other.first && this.second >= other.second
    }

    fun Pair<Int, Int>.intersects(other: Pair<Int, Int>): Boolean {
        return this.contains(other) ||
                (this.first < other.first && this.second >= other.first) ||
                (this.first <= other.second && this.second > other.second)
    }
}

