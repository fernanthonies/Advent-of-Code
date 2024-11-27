package common

fun isBitSet(number: Int, position: Int): Boolean {
    val mask = 1 shl position
    return number and mask != 0
}