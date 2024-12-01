package common

import java.util.regex.Pattern

fun CharSequence.indicesOf(input: String): List<Int> = Regex(Pattern.quote(input))
    .findAll(this)
    .map { it.range.first }
    .toCollection(mutableListOf())