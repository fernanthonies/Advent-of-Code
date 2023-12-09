package common

fun gcd(a: Long, b: Long): Long {
    if (b == 0.toLong()) return a
    return gcd(b, a % b)
}

fun lcm(a: Long, b: Long): Long {
    return a / gcd(a, b) * b
}

fun gcdOfArray(arr: LongArray): Long {
    var result = arr[0]
    for (i in 1 until arr.size) {
        result = gcd(result, arr[i])
    }
    return result
}

fun lcmOfArray(arr: LongArray): Long {
    var result = arr[0]
    for (i in 1 until arr.size) {
        result = lcm(result, arr[i])
    }
    return result
}