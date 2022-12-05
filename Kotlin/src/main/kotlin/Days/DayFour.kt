package days

fun dayFour(input: List<String>) {
    var containsTotal = 0
    var overlapsTotal = 0

    input.forEach {line ->
        val elfOne = line.split(",")[0].split("-").let{ it[0].toInt() to it[1].toInt()}
        val elfTwo = line.split(",")[1].split("-").let{ it[0].toInt() to it[1].toInt()}

        if (elfOne.contains(elfTwo) || elfTwo.contains(elfOne)) {
            containsTotal++
        }
        if (elfOne.intersects(elfTwo) || elfTwo.intersects(elfOne)) {
            overlapsTotal++
        }
    }

    println("number of contains pairs=${containsTotal}")
    println("number of intersection pairs=${overlapsTotal}")
}

fun Pair<Int, Int>.contains(other: Pair<Int, Int>): Boolean {
    return this.first <= other.first && this.second >= other.second
}

fun Pair<Int, Int>.intersects(other: Pair<Int, Int>): Boolean {
    return this.contains(other) ||
            (this.first < other.first && this.second >= other.first) ||
            (this.first <= other.second && this.second > other.second)
}