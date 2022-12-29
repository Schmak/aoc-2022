package day06

import utils.readFile

private const val MARKER_SIZE = 4

fun part1(input: String): Int =
    input.windowedSequence(MARKER_SIZE) { it.toSet().size }
        .takeWhile { it != MARKER_SIZE }
        .count() + MARKER_SIZE

fun parseInput(lines: List<String>) = lines.single()

fun main() {
    val input = parseInput(readFile("06"))
    println(part1(input))
}