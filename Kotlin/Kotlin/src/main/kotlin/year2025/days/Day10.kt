package year2025.Days

import BaseDay
import java.util.BitSet
import com.microsoft.z3.*

class Day10: BaseDay() {
    override fun solvePartOne(): String {
        val machines = input.map { Machine(it) }

        var sum = 0
        var solvedCount = 0
        machines.forEach { m ->
            val count = m.buttons.size
            val stack = ArrayDeque((0..(count - 1)).map { listOf(it) }.toList())

            var notFound = true
            loop@while (notFound) {
                val test = stack.removeFirst()
                val record = mutableSetOf<Pair<Int, BitSet>>()

                for (i in 0..(test.size - 1)) {
                    val button = test[i]
                    if (record.contains(Pair(button, m.lights))) {
                        continue@loop
                    }
                    record.add(Pair(button, m.lights.copy()))
                    m.lights.xor(m.buttons[button])
                }
                if (m.lights == m.goal) {
                    sum += test.count()
                    solvedCount += 1
                    notFound = false
                }
                ((0..(count - 1)).toList() - test).forEach { stack.addLast(test + it) }
                m.resetLights()
            }
        }

        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var sum = 0
        input.forEach { line ->
            var pattern = """\(([^)]*)\)""".toRegex()
            val matches = pattern.findAll(line)
            val buttons = matches.map { it.groupValues[1].split(",").map { it.toInt() }.toMutableSet() }.toList()

            pattern = """\{([^}]*)\}""".toRegex()
            val match = pattern.find(line)
            val goal = match?.groupValues?.get(1)?.split(",")?.map { it.toInt() }!!

            sum += solveMachine(buttons, goal)
        }
        return sum.toString()
    }

    fun solveMachine(buttons: List<Set<Int>>, target: List<Int>): Int {
        val ctx = Context()

        try {
            val optimizer = ctx.mkOptimize()
            val buttonVars = buttons.indices.map { i ->
                ctx.mkIntConst("btn_$i")
            }

            for (v in buttonVars) {
                optimizer.Add(ctx.mkGe(v, ctx.mkInt(0))) // can't have negative button presses
            }

            for (counter in target.indices) {
                val terms = buttons.indices
                    .filter { counter in buttons[it] }
                    .map { buttonVars[it] }

                val sum = ctx.mkAdd(*terms.toTypedArray())
                optimizer.Add(ctx.mkEq(sum, ctx.mkInt(target[counter])))
            }

            val totalPresses = ctx.mkAdd(*buttonVars.toTypedArray())
            optimizer.MkMinimize(totalPresses) // the goal is to minimize total presses

            if (optimizer.Check() == Status.SATISFIABLE) {
                val model = optimizer.model
                return buttonVars.sumOf { v ->
                    (model.evaluate(v, false) as IntNum).int
                }
            }

            return -1
        } finally {
            ctx.close()
        }
    }

    class Machine(line: String) {
        var lights: BitSet
        val initialLights: BitSet
        val goal: BitSet
        val buttons: List<BitSet>
        var buttonPresses: Int = 0

        init {
            val lightString = line.drop(1).split("]")
            lights = BitSet(lightString.size)
            initialLights = lights.copy()
            goal = BitSet(lightString.size)
            lightString[0].forEachIndexed { index, string ->
                if (string == '#') goal.set(index)
            }

            val pattern = """\(([^)]*)\)""".toRegex()
            val matches = pattern.findAll(line)
            buttons = matches.map { it.groupValues[1] }.toList().map { s ->
                val split = s.split(",")
                val bits = BitSet(split.size)
                split.forEach { b -> bits.set(b.toInt()) }
                bits
            }
        }

        fun resetLights() {
            lights.clear()
        }

        fun pressAndCheck(button: Int): Boolean {
            lights.xor(buttons[button])
            buttonPresses += 1
            return lights == goal
        }
    }
}

fun BitSet.copy(): BitSet {
    return this.clone() as BitSet
}
