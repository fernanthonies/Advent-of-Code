package year2024.Days

import BaseDay
import common.midpoint

@OptIn(ExperimentalStdlibApi::class)
class Day5: BaseDay() {
    override fun solvePartOne(): String {
        val split = input.indexOf("")
        val rules = input.slice(0..<split).map { Pair(it.split("|")[0].toInt(), it.split("|")[1].toInt()) }
        val updates = input.slice(split + 1..<input.size).map { it.split(",") }

        val post = rules.groupBy { it.first }.mapValues { e -> e.value.map { it.second } }.withDefault { listOf() }
        val pre = rules.groupBy { it.second }.mapValues { e -> e.value.map { it.first } }.withDefault { listOf() }

        var sum = 0
        for(update in updates) {
            val ints = update.map { it.toInt() }
            if(!ints.any { p ->
                val i = ints.indexOf(p)
                post.filter { ints.slice(i + 1..<update.size).contains(it.key) }.values.any { it.contains(p) } ||
                        pre.filter { ints.slice(0..<i).contains(it.key) }.values.any { it.contains(p) }
            }) {
                sum += ints.midpoint()
            }
        }

        return sum.toString()
    }

    override fun solvePartTwo(): String {
        val split = input.indexOf("")
        val rules = input.slice(0..<split).map { Pair(it.split("|")[0].toInt(), it.split("|")[1].toInt()) }
        val updates = input.slice(split + 1..<input.size).map { it.split(",") }

        val post = rules.groupBy { it.first }.mapValues { e -> e.value.map { it.second } }.withDefault { listOf() }
        val pre = rules.groupBy { it.second }.mapValues { e -> e.value.map { it.first } }.withDefault { listOf() }

        var sum = 0
        for(update in updates) {
            val ints = update.map { it.toInt() }
            if(ints.any { p ->
                    val i = ints.indexOf(p)
                    post.filter { ints.slice(i + 1..<update.size).contains(it.key) }.values.any { it.contains(p) } ||
                            pre.filter { ints.slice(0..<i).contains(it.key) }.values.any { it.contains(p) }
                }) {
                val newList = mutableListOf<Int>()
                ints.forEach { p ->
                    newList.firstOrNull { post[p]?.contains(it) ?: false }?.let {
                        newList.add(newList.indexOf(it), p)
                    } ?: newList.lastOrNull { pre[p]?.contains(it) ?: false }?.let {
                        newList.add(newList.indexOf(it) + 1, p)
                    } ?: run {
                        newList.add(p)
                    }
                }
                sum += newList.midpoint()
            }
        }

        return sum.toString()
    }
}