package year2025.Days

import BaseDay
import common.Grid

class Day6: BaseDay() {
    override fun solvePartOne(): String {
        val rows = input.map { line -> line.split(Regex("\\s+"))}.map { r -> r.filter { it.isNotBlank() } }
        val columns = Grid(rows).columns()
        return columns.sumOf { row -> calculateRow(row) }.toString()
    }

    override fun solvePartTwo(): String {
        val grid = Grid.fromStringInput(input)
        val columns = grid.columns().fold(mutableListOf(mutableListOf<List<String>>())) { acc, item ->
            if (item.all { it == " " }) {
                acc.add(mutableListOf())
            } else {
                acc.last().add(item)
            }
            acc
        }
        return columns.sumOf { lists ->
            calculateCephalopodRow(lists)
        }.toString()
    }

    private fun calculateRow(row: List<String>): Long {
        return when (row.last()) {
            "*" -> {
                row.dropLast(1).map { it.toLong() }.reduce { acc, i -> acc * i }
            }
            "+" -> {
                row.dropLast(1).map { it.toLong() }.reduce { acc, i -> acc + i }
            }
            else -> {0}
        }
    }

    private fun calculateCephalopodRow(problemSet: List<List<String>>): Long {
        return when (problemSet[0].last()) {
            "*" -> {
                problemSet.map { list -> list.filter { it[0].isDigit() }.joinToString("").toLong() }.reduce { acc, lng -> acc * lng }
            }

            "+" -> {
                problemSet.map { list -> list.filter { it[0].isDigit() }.joinToString("").toLong() }.reduce { acc, lng -> acc + lng }
            }
            else -> {0}
        }
    }
}