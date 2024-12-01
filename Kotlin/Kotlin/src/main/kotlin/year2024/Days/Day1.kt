package year2024.Days

import BaseDay
import kotlin.math.abs

class Day1 : BaseDay() {
    override fun solvePartOne(): String {
        val listOne = mutableListOf<Int>()
        val listTwo = mutableListOf<Int>()
        input.forEach { line ->
            listOne.add(line.split("   ")[0].toInt())
            listTwo.add(line.split("   ")[1].toInt())
        }
        listOne.sort()
        listTwo.sort()
        return listOne.zip(listTwo).sumOf {
            abs(it.first - it.second)
        }.toString()
    }

    override fun solvePartTwo(): String {
        val listOne = mutableListOf<Int>()
        val listTwo = mutableListOf<Int>()
        input.forEach { line ->
            listOne.add(line.split("   ")[0].toInt())
            listTwo.add(line.split("   ")[1].toInt())
        }
        val grouping = listTwo.groupingBy { it }.eachCount()
        return listOne.sumOf {
            it * (grouping[it] ?: 0)
        }.toString()
    }
}