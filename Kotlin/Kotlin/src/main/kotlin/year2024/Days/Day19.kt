package year2024.Days

import BaseDay

class Day19: BaseDay() {
    override fun solvePartOne(): String {
        val patterns = input.first().split(", ")

        return input.drop(2).count {
            findMatches(patterns, it)
        }.toString()
    }

    override fun solvePartTwo(): String {
        val patterns = input.first().split(", ")

        return input.drop(2).sumOf {
            findMatchCounts(patterns, it)
        }.toString()
    }

    private fun findMatches(patterns: List<String>, design: String, memo: MutableMap<String, Boolean> = mutableMapOf()): Boolean {
        if (design == "") return true
        return memo.getOrPut(design) {
            patterns.filter { design.startsWith(it) }.any {
                findMatches(patterns, design.removePrefix(it), memo)
            }
        }
    }

    private fun findMatchCounts(patterns: List<String>, design: String, memo: MutableMap<String, Long> = mutableMapOf()): Long {
        if (design == "") return 1
        return memo.getOrPut(design) {
            patterns.filter { design.startsWith(it) }.sumOf {
                findMatchCounts(patterns, design.removePrefix(it), memo)
            }
        }
    }
}