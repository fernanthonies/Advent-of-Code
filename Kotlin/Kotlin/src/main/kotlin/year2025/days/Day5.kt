package year2025.Days

import BaseDay
import common.Range
import common.splitOn

class Day5: BaseDay() {
    override fun solvePartOne(): String {

        val (freshList, ids) = input.splitOn("")

        val freshRanges = freshList.map {
            Range(it.split("-")[0].toLong(), it.split("-")[1].toLong())
        }
        val mergedRanges = Range.mergeRanges(freshRanges)
        return ids.count { id -> mergedRanges.any { range -> range.contains(id.toLong()) } }.toString()
    }

    override fun solvePartTwo(): String {
        val (freshList, _) = input.splitOn("")
        val freshRanges = freshList.map {
            Range(it.split("-")[0].toLong(), it.split("-")[1].toLong())
        }
        val mergedRanges = Range.mergeRanges(freshRanges)
        return mergedRanges.sumOf { it.size() }.toString()
    }
}