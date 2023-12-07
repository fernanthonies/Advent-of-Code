package year2023.Days

import BaseDay

class DaySeven(input: List<String>) : BaseDay(input) {

    override fun solvePartOne(): String {

        val hands: MutableList<Triple<String, Int, Int>> = mutableListOf()
        for (line in input) {
            val split = line.split(" ")
            hands.add(Triple(split[0], split[1].toInt(), getStrength(split[0])))
        }

        hands.sortWith( Comparator { o1, o2 ->
            if (o1.third != o2.third) {
                o1.third - o2.third
            } else {
                compareEqualHands(o1.first, o2.first, false)
            }
        })

        var sum = 0
        for ((i, hand) in hands.withIndex()) {
            sum += ((i + 1) * hand.second)
        }

        return sum.toString()
    }

    override fun solvePartTwo(): String {

        return ""
    }

    fun getStrength(hand: String): Int {
        val groups = hand.groupBy { it }
        return if (groups.count() == 5) {
            1
        } else if (groups.count() == 4) {
            2
        } else if (groups.count() == 3) {
            if (groups.values.map { it.count() }.maxOf { it } == 2) {
                3
            } else {
                4
            }
        } else if (groups.count() == 2) {
            if (groups.values.map { it.count() }.maxOf { it } == 3) {
                5
            } else {
                6
            }
        } else if (groups.count() == 1) {
            7
        } else {
            -1
        }
    }

    fun getStrengthWithJokers(hand: String): Int {
        val jokerCount = hand.count { it == 'J' }
        val newHand = hand.filter { it != 'J' }
        val groups = hand.groupBy { it }
        return if (groups.count() == 5) {
            1
        } else if (groups.count() == 4) {
            2
        } else if (groups.count() == 3) {
            if (groups.values.map { it.count() }.maxOf { it } == 2) {
                3
            } else {
                4
            }
        } else if (groups.count() == 2) {
            if (groups.values.map { it.count() }.maxOf { it } == 3) {
                5
            } else {
                6
            }
        } else if (groups.count() == 1) {
            7
        } else {
            -1
        }
    }

    fun compareEqualHands(handOne: String, handTwo: String, jokers: Boolean): Int {

        val cardStrength = if (jokers) {
            listOf('A', 'K', 'Q', 'T', '9', '8', '7', '6', '5', '4', '3', '2', 'J').reversed()
        } else {
            listOf('A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2').reversed()
        }

        val first = handOne[0]
        val second = handTwo[0]

        if (handOne.isEmpty()) return 0

        return if (cardStrength.indexOf(first) > cardStrength.indexOf(second)) {
            1
        } else if (cardStrength.indexOf(first) < cardStrength.indexOf(second)) {
            -1
        } else {
            if (handOne.length == 1) {
                0
            } else {
                compareEqualHands(handOne.substring(1), handTwo.substring(1), jokers)
            }
        }
    }
}

// same rank compare recursively