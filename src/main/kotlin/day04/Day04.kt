package day04

import utils.readFile


fun part1(input: List<Pair<IntRange, IntRange>>): Int =
    input.count { (a, b) -> a in b || b in a }

fun parseInput(lines: List<String>) =
    lines.map { it.split(",").map(String::asRange).let { (a, b) -> a to b } }

private val String.asRange: IntRange
    get() =
        split("-")
            .map(String::toInt)
            .let { (start, end) -> start..end }

private operator fun IntRange.contains(other: IntRange): Boolean =
    this.first <= other.first && this.last >= other.last

fun main() {
    val input = parseInput(readFile("04"))
    println(part1(input))
}