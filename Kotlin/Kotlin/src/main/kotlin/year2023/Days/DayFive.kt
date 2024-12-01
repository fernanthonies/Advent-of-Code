package year2023.Days

import BaseDay

class DayFive : BaseDay() {
    override fun solvePartOne(): String {
        val seeds = input[0].split(" ").drop(1).map { it.toLong() }
        val steps: MutableList<MutableList<Mapping>> = generateSteps(input)

        var min = Long.MAX_VALUE

        for (seed in seeds) {
            var currentValue = seed
            for (step in steps) {
                var mappedValue: Long? = null
                for (mapping in step) {
                    mapping.mapValue(currentValue)?.let {
                        mappedValue = it
                    }
                }
                mappedValue?.let { currentValue = it }
            }
            if (currentValue < min) {
                min = currentValue
            }
        }

        return min.toString()
    }

    override fun solvePartTwo(): String {
        val seedRangePairs: MutableList<Pair<Long, Long>> = mutableListOf()
        val seedValues = input[0].split(" ").drop(1).map { it.toLong() }
        for (i in seedValues.indices step 2) {
            seedRangePairs.add(Pair(seedValues[i], seedValues[i] + seedValues[i + 1] - 1))
        }
        val steps: MutableList<MutableList<Mapping>> = generateSteps(input)

        val results: MutableList<Pair<Long, Long>> = mutableListOf()
        for (seedRange in seedRangePairs) {
            var stepInput: MutableList<Pair<Long, Long>> = mutableListOf(seedRange)
            for (step in steps) {
                val mappedRanges: MutableList<Pair<Long, Long>> = mutableListOf()
                var mappingInput = stepInput
                for (mapping in step) {
                    val remainingRanges: MutableList<Pair<Long, Long>> = mutableListOf()
                    for (rangePair in mappingInput) {
                        val (mappedRange, newRangesToAdd) = mapping.mapRange(rangePair)
                        mappedRange?.let { mappedRanges.add(it) }
                        remainingRanges.addAll(newRangesToAdd)
                    }
                    mappingInput = remainingRanges
                }
                mappedRanges.addAll(mappingInput)
                stepInput = mappedRanges
            }
            results.addAll(stepInput)
        }

        return results.map { it.first }.minOf { it }.toString()
    }
}

private fun generateSteps(input: List<String>): MutableList<MutableList<Mapping>> {
    val steps: MutableList<MutableList<Mapping>> = mutableListOf()

    var chunk: MutableList<String> = mutableListOf()
    val chunks: MutableList<MutableList<String>> = mutableListOf()
    for (line in input.drop(2)) {
        if (line.isBlank()) {
            chunks.add(chunk)
            chunk = mutableListOf()
        } else {
            chunk.add(line)
        }
    }
    //add last chunk
    chunks.add(chunk)

    for (c in chunks) {
        val stepMappings: MutableList<Mapping> = mutableListOf()
        for (line in c.drop(1)) {
            val (destination, source, range) = line.split(" ").map { it.toLong() }
            stepMappings.add(Mapping(source, destination, range))
        }
        steps.add(stepMappings)
    }
    return steps
}

class Mapping(val source: Long, destination: Long, val range: Long) {
    val diff: Long = destination - source

    fun mapValue(value: Long): Long? {
        return if (value.inRange(source, range)) {
            value + diff
        } else {
            null
        }
    }

    fun mapRange(rangePair: Pair<Long, Long>): Pair<Pair<Long, Long>?, List<Pair<Long, Long>>> {
        return if (rangePair.first.inRange(source, range) && rangePair.second.inRange(source, range)) {
            //rangePair is completely in range
            Pair(Pair(rangePair.first + diff, rangePair.second + diff), listOf())
        } else if (rangePair.first.inRange(source, range)) {
            //rangePair starts in range
            Pair(Pair(rangePair.first + diff, source + range - 1 + diff), listOf(Pair(source + range, rangePair.second)))
        } else if (rangePair.second.inRange(source, range)) {
            //rangePair ends in range
            Pair(Pair(source + diff, rangePair.second + diff), listOf(Pair(rangePair.first, source - 1)))
        } else {
            //rangePair is completely out of range
            if (rangePair.second < source || rangePair.first > source + range - 1) {
                //rangePair is completely out of range
                Pair(null, listOf(rangePair))
            } else {
                //rangePair completely subsumes range
                Pair(Pair(source + diff, source + range - 1 + diff), listOf(Pair(rangePair.first, source - 1), Pair(source + range, rangePair.second)))
            }
        }
    }

    private fun Long.inRange(start: Long, length: Long): Boolean {
        return this >= start && this < start + length
    }
}