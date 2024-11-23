package year2021.Days

import BaseDay
import common.zipWithN

class Day1 : BaseDay() {
    override fun solvePartOne(): String {
        return input.map { it.toInt() }.zipWithNext { a: Int, b: Int -> b > a }.count { it }.toString()
    }

    override fun solvePartTwo(): String {
        return input.map { it.toInt() }.zipWithN(3) { l -> l.sum() }.zipWithNext { a: Int, b: Int -> b > a }.count { it }.toString()
    }
}