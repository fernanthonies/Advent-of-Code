@file:Suppress("KotlinConstantConditions")

import java.io.File

const val YEAR = 2023
const val DAY = 11

fun main() {
    val input = readFile("./input/${YEAR}/day${DAY}.txt")

    val day = when(YEAR) {
        2022 -> getDayFromYear2022(DAY, input)
        2023 -> getDayFromYear2023(DAY, input)
        else -> throw Error()
    }
    day.solve()
}

fun getDayFromYear2023(dayCode: Int, input: List<String>): BaseDay {
    return when(dayCode) {
        1 -> year2023.Days.DayOne(input)
        2 -> year2023.Days.DayTwo(input)
        3 -> year2023.Days.DayThree(input)
        4 -> year2023.Days.DayFour(input)
        5 -> year2023.Days.DayFive(input)
        6 -> year2023.Days.DaySix(input)
        7 -> year2023.Days.DaySeven(input)
        8 -> year2023.Days.DayEight(input)
        9 -> year2023.Days.DayNine(input)
        10 -> year2023.Days.DayTen(input)
        11 -> year2023.Days.DayEleven(input)
        else -> throw Error()
    }
}

fun getDayFromYear2022(dayCode: Int, input: List<String>): BaseDay {
    return when(dayCode) {
        1 -> year2022.Days.DayOne(input)
        2 -> year2022.Days.DayTwo(input)
        3 -> year2022.Days.DayThree(input)
        4 -> year2022.Days.DayFour(input)
        5 -> year2022.Days.DayFive(input)
        6 -> year2022.Days.DaySix(input)
        7 -> year2022.Days.DaySeven(input)
        8 -> year2022.Days.DayEight(input)
        9 -> year2022.Days.DayNine(input)
        10 -> year2022.Days.DayTen(input)
        else -> throw Error()
    }
}

fun readFile(fileName: String): List<String> {
    return File(fileName).useLines { it.toList() }
}