package year2023.Days

import BaseDay

class DayTwelve : BaseDay() {
    override fun solvePartOne(): String {
        var solutionCount = 0
        for (line in input) {
            val springArray = line.split(" ").first()
            val nonogram = line.split(" ").last().split(',').map { it.toInt() }
            var solutions = mutableListOf<String>()

            var allSolutionsFound = false
            var lineSolutionCount = 0
            var groupSolutionsFound = 0
            var groupSolutionIndex = 0
            while (!allSolutionsFound) {
                var solution: String = ""
                val groups = ArrayDeque(nonogram)
                var group = groups.removeFirst()
                var groupIndex = 0
                var i = 0
                //var solutionOffset = lineSolutionCount
                while (i < springArray.length) {
                    when (springArray[i]) {
                        '.' -> {
                            solution += '.'
                            i++
                        }
                        '#', '?' -> {
                            var test = springArray.substring(i).takeWhile { it == '#' || it == '?' }
                            if (groupIndex == groupSolutionIndex) {
                                solution += "".padEnd(groupSolutionsFound, '.')
                                i += groupSolutionsFound
                                test = test.substring(groupSolutionsFound)
                            }
                            if (test.length >= group) {
                                if (i + group < springArray.length && springArray[i + group] == '#') {
                                    solution += '.'
                                    i++
                                    continue
                                }

//                                i += lineSolutionCount
//                                solution += "".padEnd(lineSolutionCount, '.')

                                solution += "".padEnd(group, '#')
                                if (i < line.length - 1) {
                                    solution += '.'
                                    i += group + 1
                                }
                                if (groups.any()) {
                                    group = groups.removeFirst()
                                    groupIndex++
                                } else {
                                    break
                                }
                            } else {
                                solution += '.'
                                i++
                            }
                        }
                    }
                }
                if (groups.any()) {
                    // no solution
                    if (groupSolutionIndex == nonogram.count()) {
                        allSolutionsFound = true
                    } else {
                        groupSolutionIndex++
                        groupSolutionsFound = 0
                    }
                } else {
                    groupSolutionsFound++
                    lineSolutionCount++
                }
            }
        }
        return solutionCount.toString()
    }

    override fun solvePartTwo(): String {
        return ""
    }
}