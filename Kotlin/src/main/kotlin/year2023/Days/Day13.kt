package year2023.Days

import BaseDay
import common.Grid
import common.mirroredOnPivot

class Day13: BaseDay() {
    val partOneSolutions: MutableMap<Int, Int> = mutableMapOf()

    override fun solvePartOne(): String {
        val temp = input.lastIndex..1
        val grids = buildGridList(input)
        var result = 0
        for (g in 0..grids.size - 1) {
            val grid = grids[g]
            var solution: Int = -1
            solution = findGridSolution(grid)

            if (solution == -1) {
                solution = findGridSolution(grid.transpose())
                result += solution * 100
            } else {
                result += solution
            }
            partOneSolutions[g] = solution
            if (solution == -1) {
                throw Error()
            }
        }

        return result.toString()
    }

    override fun solvePartTwo(): String {
        val grids = buildGridList(input)
        var result = 0
        gridLoop@for (g in 0..grids.size - 1) {
            val oGrid = grids[g]

            for(y in 0..oGrid.height - 1) {
                innerGridLoop@for (x in 0..oGrid.width - 1) {
                    val grid = Grid(oGrid)
                    if (grid[y,x] == ".") {
                        grid[y, x] = "#"
                    } else {
                        continue@innerGridLoop
                    }
//                    when (grid[y, x]) {
//                        "." -> grid[y, x] = "#"
//                        "#" -> grid[y, x] = "."
//                    }

                    var solution: Int = -1
                    solution = findGridSolution(grid, partOneSolutions[g])

                    if (solution == -1) {
                        solution = findGridSolution(grid.transpose(), partOneSolutions[g])
                        if (solution == -1) {
                            continue@innerGridLoop
                        }
                        result += solution * 100
                    } else {
                        result += solution
                    }
                    if (solution != -1) {
                        continue@gridLoop
                    }
                }
            }
        }

        return result.toString()
    }

    fun buildGridList(input: List<String>): List<Grid<String>> {
        val gridList = mutableListOf<Grid<String>>()
        var tempList: MutableList<String> = mutableListOf()
        input.forEach { line ->
            if (line.isNotBlank()) {
                tempList.add(line)
            } else {
                gridList.add(Grid.fromStringInput(tempList))
                tempList = mutableListOf()
            }
        }
        gridList.add(Grid.fromStringInput(tempList))
        return gridList
    }

    fun findGridSolution(grid: Grid<String>, skipSolution: Int? = null): Int {
        var result = -1
        val gridRowsStrings = grid.rows().map { it.joinToString(separator = "") }
        //var rowString = gridRowsStrings.first()
        pivotLoop@ for (i in 1..grid.width - 1 ) {
            if (skipSolution != null && skipSolution == i) {
                continue@pivotLoop
            }
            for(j in 0..gridRowsStrings.size - 1) {
                if (!gridRowsStrings[j].mirroredOnPivot(i)) {
                    continue@pivotLoop
                }
            }
            result = i
        }
        return result
    }
}