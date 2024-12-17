package year2024.Days

import BaseDay

class Day11: BaseDay() {
    private var sum = 0
    override fun solvePartOne(): String {
        val inputList = input.first().split(" ")
        val tree = build(inputList)

        sum = inputList.size
        for (i in 1..25) {
            process(tree)
        }

        return sum.toString()
    }

    override fun solvePartTwo(): String {
        val inputList = input.first().split(" ")

        var stoneMap = mutableMapOf<Long, Long>()
        inputList.forEach {
            stoneMap[it.toLong()] = 1
        }

        sum = inputList.size
        for (i in 1..75) {
            val newMap = mutableMapOf<Long, Long>()
            stoneMap.forEach { e ->
                val key = e.key
                val n = e.value
                when {
                    key == 0L -> {
                        newMap[1] = newMap.getOrDefault(1, 0) + n
                    }
                    key.toString().length % 2 == 0 -> {
                        val mid = key.toString().length / 2
                        val left = key.toString().substring(0, mid).toLong()
                        newMap[left] = newMap.getOrDefault(left, 0) + n
                        val right = key.toString().substring(mid).toLong()
                        newMap[right] = newMap.getOrDefault(right, 0) + n
                    }
                    else -> {
                        val k = key * 2024
                        newMap[k] = newMap.getOrDefault(k, 0) + n
                    }
                }
            }
            stoneMap = newMap
        }

        return stoneMap.map { it.value }.reduce { acc, i -> acc + i }.toString()
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun build(input: List<String>): Node {
        val n = Node()
        if (input.size == 1) {
            n.contents = input.first()
        } else {
            val mid = input.size / 2
            n.left = build(input.slice(0..<mid))
            n.right = build(input.slice(mid..<input.size))
        }


        return n
    }

    fun process(node: Node?) {
        if (node == null) return
        node.contents?.let {
            when {
                it == "0" -> {
                    node.contents = "1"
                }
                it.length % 2 == 0 -> {
                    val mid = it.length / 2
                    node.left = Node().apply { contents = it.substring(0, mid) }
                    node.right = Node().apply { contents = it.substring(mid).toInt().toString() }
                    node.contents = null
                    sum += 1
                }
                else -> {
                    node.contents = (it.toLong() * 2024).toString()
                }
            }
        } ?: run {
            process(node.left)
            process(node.right)
        }
    }

    class Node {
        var contents: String? = null
        var left: Node? = null
        var right: Node? = null
    }
}