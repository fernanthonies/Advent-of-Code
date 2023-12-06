package year2023.Days

import BaseDay

class DaySix(input: List<String>) : BaseDay(input) {
    override fun solvePartOne(): String {
        val times = input[0].split("[\\s,]+".toRegex()).drop(1).map { it.toLong() }
        val distances = input[1].split("[\\s,]+".toRegex()).drop(1).map { it.toLong() }

        val games = times.zip(distances).toMap()
        return solve(games).toString()
    }

    override fun solvePartTwo(): String {
        val times = input[0].split("[\\s,]+".toRegex()).drop(1).map { it.toLong() }.joinToString("").toLong()
        val distances = input[1].split("[\\s,]+".toRegex()).drop(1).map { it.toLong() }.joinToString("").toLong()

        val games = mapOf(times to distances)
        return solve(games).toString()
    }

    fun solve (input: Map<Long, Long>): Long {
        var sum: Long = 1
        var count = 0
        for (game in input) {
            val (time, distance) = game
            val mid = time / 2
            val predicate: (Long) -> Boolean = { i ->
                count++
                val remainingTime = time - i
                val distanceTraveled = i * remainingTime
                distanceTraveled > distance
            }
            val low = binarySearch(0, mid, true, predicate)
            val high = binarySearch(mid, time, false, predicate)
            println("comparison count: $count")
            sum *= high - low
        }
        return sum
    }

    fun binarySearch(lowInput: Long, highInput: Long, lhs: Boolean, test: (Long) -> Boolean): Long {
        var low = lowInput
        var high = highInput
        while (low < high) {
            val mid = (low + high) / 2
            if (test(mid)) {
                if (lhs) high = mid else low = mid + 1
            } else {
                if (lhs) low = mid + 1 else high = mid
            }
        }
        return low
    }
}