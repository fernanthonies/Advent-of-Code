package Days

fun dayOne(input: List<String>) {
    val sumList = mutableListOf<Int>()
    var tempTotal = 0

    input.forEach { line ->
        line.toIntOrNull()?.let {
            tempTotal += it
        }?:run {
            sumList.add(tempTotal)
            tempTotal = 0
        }
    }

    sumList.sort()
    println("Highest calorie count=${sumList.last()}")
    println("Sum of top three=${sumList.takeLast(3).sum()}")
}