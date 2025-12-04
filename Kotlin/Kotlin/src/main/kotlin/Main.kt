@file:Suppress("KotlinConstantConditions")

import common.GetData

const val YEAR = 2025
const val DAY = 4

fun main() {
    val c = Class.forName("year${YEAR}.Days.Day${DAY}")
    val day = c.constructors.first().newInstance() as BaseDay
    day.setData(GetData(DAY, YEAR))
    day.solve()
}