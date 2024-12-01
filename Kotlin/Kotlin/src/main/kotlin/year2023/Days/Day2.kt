package year2023.Days

import BaseDay

class Day2() : BaseDay() {
    private val redMax: Int = 12
    private val greenMax: Int = 13
    private val blueMax: Int = 14

    override fun solvePartOne(): String {
        var sum = 0
        gameLoop@ for (game in input) {
            val gameId = game.split(":")[0].split(" ")[1].toInt()
            val rounds = game.split(":")[1]
            for (round in rounds.split(";")) {
                val red = colorCount(round, "red")
                val green = colorCount(round, "green")
                val blue = colorCount(round, "blue")

                if (red > redMax || green > greenMax || blue > blueMax) {
                    continue@gameLoop
                }
            }
            sum += gameId
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var sum = 0
        gameLoop@ for (game in input) {
            var totalRed = 0
            var totalBlue = 0
            var totalGreen = 0
            val gameId = game.split(":")[0].split(" ")[1].toInt()
            val rounds = game.split(":")[1]
            for (round in rounds.split(";")) {
                val red = colorCount(round, "red")
                val green = colorCount(round, "green")
                val blue = colorCount(round, "blue")
                totalRed = if (red > totalRed) red else totalRed
                totalGreen = if (green > totalGreen) green else totalGreen
                totalBlue = if (blue > totalBlue) blue else totalBlue
            }
            sum += totalRed * totalGreen * totalBlue
        }
        return sum.toString()
    }

    private fun colorCount(input: String, color: String): Int {
        return input.split(",").filter { it.contains(color) }.firstOrNull()?.trim()?.split(" ")?.get(0)?.toInt() ?: 0
    }
}