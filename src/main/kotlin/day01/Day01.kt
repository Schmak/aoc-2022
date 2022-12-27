package day01

import utils.readFile

fun part1(input: List<List<Int>>) = input.maxOf { it.sum() }

fun parseInput(lines: List<String>) =
    lines.fold(listOf(mutableListOf<Int>())) { acc, line ->
        line.toIntOrNull()?.let { acc.apply { last().add(it) } }
            ?: (acc + listOf(mutableListOf()))
    }

fun main() {
    val input = parseInput(readFile("01"))
    println(part1(input))
}