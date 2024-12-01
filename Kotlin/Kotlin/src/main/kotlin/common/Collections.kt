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