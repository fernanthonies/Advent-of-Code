package year2024.Days

import BaseDay

@OptIn(ExperimentalStdlibApi::class)
class Day13: BaseDay() {
    override fun solvePartOne(): String {
        var sum: Long = 0
        val inputList = input.toMutableList()
        inputList.add("")
        for (i in 0..<inputList.size - 3 step 4) {
            val subList = input.subList(i, i+3)
            val a1 = subList[0].split(" ")[2].split("+")[1].dropLast(1).toLong()
            val a2 = subList[0].split(" ")[3].split("+")[1].toLong()
            val b1 = subList[1].split(" ")[2].split("+")[1].dropLast(1).toLong()
            val b2 = subList[1].split(" ")[3].split("+")[1].toLong()
            val c1 = subList[2].split(" ")[1].split("=")[1].dropLast(1).toLong()
            val c2 = subList[2].split(" ")[2].split("=")[1].toLong()
            val solution = cramersRule(a1, b1, a2, b2, c1, c2)
            if ((solution?.first!!*a1) + (solution.second *b1) == c1 && (solution.first *a2) + (solution.second *b2) == c2) {
                sum += (solution.first * 3) + (solution.second)
            }
        }

        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var sum: Long = 0
        val inputList = input.toMutableList()
        inputList.add("")
        for (i in 0..<inputList.size - 3 step 4) {
            val subList = input.subList(i, i+3)
            val a1 = subList[0].split(" ")[2].split("+")[1].dropLast(1).toLong()
            val a2 = subList[0].split(" ")[3].split("+")[1].toLong()
            val b1 = subList[1].split(" ")[2].split("+")[1].dropLast(1).toLong()
            val b2 = subList[1].split(" ")[3].split("+")[1].toLong()
            val c1 = subList[2].split(" ")[1].split("=")[1].dropLast(1).toLong() + 10000000000000
            val c2 = subList[2].split(" ")[2].split("=")[1].toLong() + 10000000000000
            val solution = cramersRule(a1, b1, a2, b2, c1, c2)
            if ((solution?.first!!*a1) + (solution.second *b1) == c1 && (solution.first *a2) + (solution.second *b2) == c2) {
                sum += (solution.first * 3) + (solution.second)
            }
        }

        return sum.toString()
    }

    fun cramersRule(a1: Long, b1: Long, a2: Long, b2: Long, c1: Long, c2: Long): Pair<Long, Long>? {
        val D = determinant(a1, b1, a2, b2)
        if (D == 0L) {
            return null
        }
        val Dx = determinant(c1, b1, c2, b2)
        val Dy = determinant(a1, c1, a2, c2)
        return Pair(Dx / D, Dy / D)
    }

    fun determinant(a: Long, b: Long, c: Long, d: Long): Long {
        return (a * d) - (b * c)
    }
}