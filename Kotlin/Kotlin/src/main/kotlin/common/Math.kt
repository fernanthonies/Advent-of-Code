package common

import kotlin.math.abs

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

fun manhattanDistance(p1: Point, p2: Point): Int {
    return (abs(p1.x - p2.x) + abs(p1.y - p2.y))
}

fun modPow(base: Long, exponent: Long, modulus: Long): Long {
    if (modulus == 1) return 0

    var result = 1
    var exp = exponent
    var currentBase = base % modulus

    while (exp > 0) {
        if (exp % 2 == 1) {
            result = (result * currentBase) % modulus
        }
        currentBase = (currentBase * currentBase) % modulus
        exp = exp / 2
    }

    return result
}

fun modInverse(a: Long, mod: Long): Long? {
    val (gcd, x, _) = extendedGcd(a, mod)
    return if (gcd == 1L) {
        ((x % mod) + mod) % mod
    } else {
        null
    }
}

fun modInversePrime(a: Long, prime: Long): Long {
    return modPow(a, prime - 2, prime)
}

fun extendedGcd(a: Long, b: Long): Triple<Long, Long, Long> {
    if (b == 0) return Triple(a, 1, 0)

    val (gcd, x1, y1) = extendedGcd(b, a % b)
    val x = y1
    val y = x1 - (a / b) * y1
    return Triple(gcd, x, y)
}

