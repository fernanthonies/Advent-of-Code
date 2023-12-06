package year2023.Days

import BaseDay

class DaySix(input: List<String>) : BaseDay(input) {
    override fun solvePartOne(): String {
        val times = input[0].split("[\\s,]+".toRegex()).drop(1).map { it.toInt() }
        val distances = input[1].split("[\\s,]+".toRegex()).drop(1).map { it.toInt() }

        val games = times.zip(distances).toMap()

        var sum = 1
        for (game in games) {
            val (time, distance) = game
            val mid = time / 2
            val low = binarySearch(0, mid) { i ->
                val remainingTime = time - i
                val distanceTraveled = i * remainingTime
                distanceTraveled >= distance
            }
            val high = binarySearch(mid, time) { i ->
                val remainingTime = time - i
                val distanceTraveled = i * remainingTime
                distanceTraveled >= distance
            }
            sum *= high - low
        }

        return sum.toString()
    }

    override fun solvePartTwo(): String {
        return ""
    }

    fun binarySearch(lowInput: Int, highInput: Int, test: (Int) -> Boolean): Int {
        var low = lowInput
        var high = highInput
        while (low < high) {
            val mid = (low + high) / 2
            if (test(mid)) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }
}