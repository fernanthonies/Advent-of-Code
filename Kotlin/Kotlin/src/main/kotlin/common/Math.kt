package common

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

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

fun euclideanDistance(p1: Point, p2: Point): Double {
    return sqrt(
        (p2.x - p1.x).toDouble().pow(2) +
        (p2.y - p1.y).toDouble().pow(2)
    )
}

fun euclideanDistance(p1: Point3, p2: Point3): Double {
    return sqrt(
        (p2.x - p1.x).toDouble().pow(2) +
        (p2.y - p1.y).toDouble().pow(2) +
        (p2.z - p1.z).toDouble().pow(2)
    )
}

fun modPow(base: Long, exponent: Long, modulus: Long): Long {
    if (modulus == 1L) return 0

    var result = 1L
    var exp = exponent
    var currentBase = base % modulus

    while (exp > 0) {
        if (exp % 2 == 1L) {
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
    if (b == 0L) return Triple(a, 1, 0)

    val (gcd, x1, y1) = extendedGcd(b, a % b)
    val x = y1
    val y = x1 - (a / b) * y1
    return Triple(gcd, x, y)
}

