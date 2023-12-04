package year2023.Days

import BaseDay
import kotlin.math.pow

class DayFour(input: List<String>) : BaseDay(input) {
    override fun solvePartOne(): String {
        var sum = 0
        input.forEach {
            val numbers = it.split(":")[1]
            val winningNumbers = numbers.split("|")[0].trim().split(" ").filter { it.isNotEmpty() }.map { s -> s.toInt() }
            val myNumbers = numbers.split("|")[1].trim().split(" ").filter { it.isNotEmpty() }.map { s -> s.toInt() }
            val card = Card(winningNumbers, myNumbers)
            val points = 2.0.pow(card.matches() - 1)
            sum += points.toInt()
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var cards: MutableList<Card> = mutableListOf()
        input.forEach {
            val numbers = it.split(":")[1]
            val winningNumbers = numbers.split("|")[0].trim().split(" ").filter { it.isNotEmpty() }.map { s -> s.toInt() }
            val myNumbers = numbers.split("|")[1].trim().split(" ").filter { it.isNotEmpty() }.map { s -> s.toInt() }
            cards.add(Card(winningNumbers, myNumbers))
        }

        cards.forEachIndexed { index, card ->
            val matches = card.matches()
            for (i in index + 1..index + matches) {
                if (i < cards.count()) {
                    cards[i].count += card.count
                }
            }
        }

        return cards.map { it.count }.sum().toString()
    }

    class Card(private val winningNumbers: List<Int>, private val myNumbers: List<Int>, var count: Int = 1) {
        fun matches(): Int {
            return myNumbers.count { n -> winningNumbers.contains(n) }
        }
    }
}