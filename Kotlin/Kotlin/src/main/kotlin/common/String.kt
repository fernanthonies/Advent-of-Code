package common

fun String.mirroredOnPivot(pivot: Int): Boolean {
    var left = this.substring(0, pivot)
    var right = this.substring(pivot)
    if (left.length > right.length) {
        left = left.reversed().substring(0, right.length)
    }
    else if (right.length > left.length) {
        right = right.substring(0, left.length).reversed()
    }
    return left == right
}

fun String.EqualsWithTolerance(other: String, tolerance: Int): Boolean {
    if (this.length != other.length) {
        return false
    }
    var counter = 0
    for (i in 0..this.length - 1) {
        if (this[i] != other[i]) {
            counter ++
            if (counter > tolerance)
                return false
        }
    }
    return true
}