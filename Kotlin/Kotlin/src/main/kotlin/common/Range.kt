package common

import kotlin.math.max
import kotlin.math.min

data class Range(val start: Long, val end: Long): Comparable<Range> {
    init {
        require(start <= end) { "start must be less than end" }
    }

    constructor(start: Int, end: Int) : this(start.toLong(), end.toLong())

    companion object {
        fun mergeRanges(ranges: List<Range>): List<Range> {
            if (ranges.isEmpty()) return emptyList()
            if (ranges.size == 1) return ranges

            val sorted = ranges.sorted()
            val result = mutableListOf<Range>()
            var current = sorted.first()

            for (i in 1 until sorted.size) {
                val next = sorted[i]
                val merged = current.union(next)

                if (merged != null) {
                    current = merged
                } else {
                    result.add(current)
                    current = next
                }
            }

            result.add(current)
            return result
        }
    }

    fun size(): Long = end - start + 1

    fun contains(value: Long): Boolean = value in start..end
    fun contains(value: Int): Boolean = value in start..end
    fun contains(other: Range): Boolean = other.start >= start && other.end <= end

    fun overlaps(other: Range): Boolean = start <= other.end && end >= other.start

    fun adjacent(other: Range): Boolean = (end + 1 == other.start) || (other.end + 1 == start)

    fun canMergeWith(other: Range): Boolean = overlaps(other) || adjacent(other)

    fun intersect(other: Range): Range? {
        if (!overlaps(other)) return null
        return Range(max(start, other.start), min(end, other.end))
    }

    fun union(other: Range): Range? {
        if (!canMergeWith(other)) return null
        return Range(min(start, other.start), max(end, other.end))
    }

    override fun compareTo(other: Range): Int =
        compareValuesBy(this, other, { it.start }, { it.end })

}