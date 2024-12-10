package common

fun <T> List<T>.zipWithN(n: Int): List<List<T>> {
    return sequence {
        for (i in 0..this@zipWithN.size - n) {
            yield(this@zipWithN.slice(i..i+n))
        }
    }.toList()
}

fun <T, R> List<T>.zipWithN(n: Int, transform: (List<T>) -> R): List<R> {
    return sequence {
        for (i in 0..this@zipWithN.size - n) {
            yield(transform(this@zipWithN.slice(i..i+n-1)))
        }
    }.toList()
}

fun <T> List<T>.dropIndex(i: Int): List<T> {
    return listOf(this.subList(0, i), this.subList(i+1, this.size)).flatten()
}

fun <T> List<T>.midpoint(): T {
    return this[this.size / 2]
}

fun <T> List<T>.cartesianProduct(other: List<T>): List<Pair<T, T>> {
    return this.flatMap { a -> other.map { b -> a to b } }
}

fun <T> MutableList<T>.swap(first: Int, second: Int) {
    val temp = this[first]
    this[first] = this[second]
    this[second] = temp
}