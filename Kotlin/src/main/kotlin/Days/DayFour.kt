package days

fun dayFour(input: List<String>) {
    var containsTotal = 0
    var overlapsTotal = 0

    input.forEach {
        val elfOne = it.split(",")[0]
        val elfTwo = it.split(",")[1]
        val elfOneRange = IntRange(elfOne.split("-")[0].toInt(), elfOne.split("-")[1].toInt()).toSet()
        val elfTwoRange = IntRange(elfTwo.split("-")[0].toInt(), elfTwo.split("-")[1].toInt()).toSet()

        if (elfOneRange.containsAll(elfTwoRange) || elfTwoRange.containsAll(elfOneRange)) {
            containsTotal++
        }
        if (elfOneRange.intersect(elfTwoRange).any() || elfTwoRange.intersect(elfOneRange).any()) {
            overlapsTotal++
        }
    }

    println("number of contains pairs=${containsTotal}")
    println("number of intersection pairs=${overlapsTotal}")
}