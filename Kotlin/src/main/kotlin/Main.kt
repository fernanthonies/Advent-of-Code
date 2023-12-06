import java.io.File
import year2022.Days.DayTen

fun main(args: Array<String>) {
    val dayCode = args.last().toInt()
    val year = args.first().toInt()
    val input = readFile("./input/${year}/day${dayCode}.txt")
    val day = when(year) {
        2022 -> getDayFromYear2022(dayCode, input)
        2023 -> getDayFromYear2023(dayCode, input)
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