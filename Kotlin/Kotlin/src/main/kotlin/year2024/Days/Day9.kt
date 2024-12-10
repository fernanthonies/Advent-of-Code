package year2024.Days

import BaseDay
import common.swap

@OptIn(ExperimentalStdlibApi::class)
class Day9: BaseDay() {
    override fun solvePartOne(): String {
        val diskInput = input.first()
        val blocks = mutableListOf<String>()
        var id = 0
        diskInput.forEachIndexed { index, c ->
            if (index % 2 == 0) {
                blocks.addAll(List(c.digitToInt()) { id.toString() })
                id++
            } else {
                blocks.addAll(List(c.digitToInt()) { "." })
            }
        }
        var i = 0
        var j = blocks.size - 1
        var forward = true
        var sum: Long = 0
        while (i < j) {
            if (forward) {
                val c = blocks[i]
                if (c == ".") {
                    forward = false
                } else {
                    sum += c.toInt() * i
                    i++
                }
            } else {
                val c = blocks[j]
                if (c == ".") {
                    j--
                } else {
                    blocks.swap(i, j)
                    forward = true
                }
            }
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        val diskInput = input.first()
        var id = 0
        var position = 0

        val fileBlocks = mutableMapOf<Int, Pair<Int, Int>>() //Map<fileId, <blockIndex, length>>
        val freeBlocks = mutableListOf<MutableList<Int>>() //Map<blockIndex, length>
        diskInput.forEachIndexed { index, c ->
            if (index % 2 == 0) {
                val size = c.digitToInt()
                fileBlocks[id] = Pair(position, size)
                position += size
                id++
            } else {
                val size = c.digitToInt()
                freeBlocks.add(mutableListOf(position, size))
                position += size
            }
        }

        for (i in id-1 downTo 0) {
            val file = fileBlocks[i]!!

            var idx = 0
            while(freeBlocks[idx][0] < file.first) {
                if (freeBlocks[idx][1] >= file.second) {
                    fileBlocks[i] = Pair(freeBlocks[idx][0], file.second)
                    freeBlocks[idx][0] += file.second
                    freeBlocks[idx][1] -= file.second
                    break
                }
                idx++
            }
        }

        var sum: Long = 0
        fileBlocks.forEach {file ->
            (0..<file.value.second).forEach {i ->
                sum += file.key * (file.value.first + i)
            }
        }

        return sum.toString()
    }
}