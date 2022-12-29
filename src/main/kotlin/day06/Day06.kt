package day06

import utils.readFile

fun part1(input: String): Int = findStart(input, 4)

fun part2(input: String): Int = findStart(input, 14)

private fun findStart(input: String, markerSize: Int): Int =
    input.windowedSequence(markerSize) { it.toSet().size }
        .takeWhile { it != markerSize }
        .count() + markerSize

fun parseInput(lines: List<String>) = lines.single()

fun main() {
    val input = parseInput(readFile("06"))
    println(part1(input))
    println(part2(input))
}