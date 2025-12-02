package common

class FrequencyMap<T>() {
    private val internalMap: MutableMap<T, Int> = mutableMapOf()

    constructor(items: Collection<T>) : this() {
        items.forEach { increment(it) }
    }

    fun increment(key: T, amount: Int = 1) {
        internalMap[key] = internalMap.getOrDefault(key, 0) + amount
    }

    fun decrement(key: T, amount: Int = 1) {
        val newValue = internalMap.getOrDefault(key, 0) - amount
        if (newValue <= 0) {
            internalMap.remove(key)
        } else {
            internalMap[key] = newValue
        }
    }

    operator fun get(key: T): Int {
        return internalMap.getOrDefault(key, 0)
    }

    operator fun set(key: T, value: Int) {
        internalMap[key] = value
    }

    fun total(): Int {
        return internalMap.values.sum()
    }

    fun mostCommon(n: Int? = null): List<Pair<T, Int>> {
        val sorted = internalMap.toList().sortedByDescending { it.second }
        return if (n == null) sorted else sorted.take(n)
    }
}