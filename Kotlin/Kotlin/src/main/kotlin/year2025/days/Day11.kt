package year2025.Days

import BaseDay

class Day11: BaseDay() {
    override fun solvePartOne(): String {
        val devices = buildMap {
            input.forEach { line ->
                val device = line.split(":")[0]
                val connections = line.split(":")[1].trim().split(" ")
                put(device, connections)
            }
        }
        return traverse("you", devices, "out").toString()
    }

    override fun solvePartTwo(): String {
        val devices = buildMap {
            input.forEach { line ->
                val device = line.split(":")[0]
                val connections = line.split(":")[1].trim().split(" ")
                put(device, connections)
            }
        }
        return traverse("svr", devices, listOf("dac", "fft"), mutableMapOf()).toString()
    }

    fun traverse(node: String, devices: Map<String, List<String>>, goal: String): Int {
        return if (node == goal ) {
            1
        } else {
            devices[node]?.sumOf { s ->
                traverse(s, devices, goal)
            } ?: 0
        }
    }

    fun traverse(node: String, devices: Map<String, List<String>>, neededNodes: List<String>, visited: MutableMap<String, Long>): Long {
        return if (node == "out") {
            if (neededNodes.isEmpty()) 1 else 0
        } else if (visited[node + neededNodes] != null) {
            visited[node + neededNodes]!!
        } else {
            val children = devices[node]
            val result = children?.sumOf { s ->
                traverse(s, devices, neededNodes - s, visited)
            } ?: 0
            visited[node + neededNodes] = result
            result
        }
    }
}