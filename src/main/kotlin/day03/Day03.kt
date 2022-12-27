package day03

import utils.readFile

fun part1(input: List<String>): Int =
    input.sumOf {
        val middle = it.length / 2
        setOf(
            it.take(middle),
            it.substring(middle)
        ).commonChar.priority
    }

fun part2(input: List<String>): Int = input.chunked(3).sumOf { it.commonChar.priority }

fun main() {
    val input = readFile("03")
    println(part1(input))
    println(part2(input))
}

private val Collection<String>.commonChar: Char
    get() = asSequence().map(String::toSet).reduce { a, b -> a.intersect(b) }.single()

private val Char.priority
    get() = when (this) {
        in 'a'..'z' -> this - 'a' + 1
        else -> this - 'A' + 27
    }