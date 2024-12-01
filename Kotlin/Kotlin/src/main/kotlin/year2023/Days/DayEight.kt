package year2023.Days

import BaseDay
import common.lcmOfArray

class DayEight : BaseDay() {

    override fun solvePartOne(): String {
        val instructions = input[0].toCharArray()

        val nodes: MutableList<Node> = mutableListOf()
        val links: MutableList<Pair<String, String>> = mutableListOf()
        for (line in input.drop(2)) {
            nodes.add(Node(line.split(" ")[0]))
            links.add(Pair(line.split(" ")[2].substring(1, 4), line.split(" ")[3].substring(0, 3)))
        }

        for (node in nodes) {
            node.left = nodes.find { it.name == links[nodes.indexOf(node)].first }
            node.right = nodes.find { it.name == links[nodes.indexOf(node)].second }
        }

        var currentNode: Node = nodes.find { it.name == "AAA" }!!
        var step = 0
        do  {
            val direction = instructions[step % instructions.count()]
            currentNode = if (direction == 'R') currentNode.right!! else currentNode.left!!
            step++
        } while (currentNode.name != "ZZZ")

        return step.toString()
    }

    override fun solvePartTwo(): String {
        val instructions = input[0].toCharArray()

        val nodes: MutableList<Node> = mutableListOf()
        val links: MutableList<Pair<String, String>> = mutableListOf()
        for (line in input.drop(2)) {
            nodes.add(Node(line.split(" ")[0]))
            links.add(Pair(line.split(" ")[2].substring(1, 4), line.split(" ")[3].substring(0, 3)))
        }

        for (node in nodes) {
            node.left = nodes.find { it.name == links[nodes.indexOf(node)].first }
            node.right = nodes.find { it.name == links[nodes.indexOf(node)].second }
        }

        val currentNodes = nodes.filter { it.name[2] == 'A' }.toMutableList()
        val solutions = LongArray(currentNodes.count())

        for ((i, node) in currentNodes.withIndex()) {
            var currentNode: Node = node
            var step = 0
            do  {
                val direction = instructions[step % instructions.count()]
                currentNode = if (direction == 'R') currentNode.right!! else currentNode.left!!
                step++
            } while (currentNode.name[2] != 'Z')

            solutions[i] = step.toLong()
        }

        return lcmOfArray(solutions).toString()
    }

    class Node(val name: String) {
        var left: Node? = null
        var right: Node? = null
    }

}