@file:Suppress("KotlinConstantConditions")

import common.GetData
import kotlin.reflect.*

const val YEAR = 2023
const val DAY = 13

fun main() {
    val c = Class.forName("year${YEAR}.Days.Day${DAY}")
    val day = c.constructors.first().newInstance() as BaseDay
    day.setData(GetData(DAY, YEAR))
    day.solve()
}