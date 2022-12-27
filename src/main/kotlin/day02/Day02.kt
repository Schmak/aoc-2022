package day02

import day02.Action.*
import day02.Result.*
import utils.readFile

private val map = mapOf('A' to Rock, 'B' to Paper, 'C' to Scissors, 'X' to Rock, 'Y' to Paper, 'Z' to Scissors)

fun part1(input: List<Round>): Int = input.sumOf { it.result.value + it.p2.value }

fun parseInput(lines: List<String>) = lines.map { Round(map.getValue(it[0]), map.getValue(it[2])) }

fun main() {
    val input = parseInput(readFile("02"))
    println(part1(input))
}

enum class Action(val value: Int) {
    Rock(1),
    Paper(2),
    Scissors(3),
}

enum class Result(val value: Int) {
    Loss(0),
    Draw(3),
    Win(6),
}

data class Round(
    val p1: Action,
    val p2: Action,
) {
    val result: Result = when {
        p1 == p2 -> Draw
        when (p1) {
            Rock -> Paper
            Paper -> Scissors
            Scissors -> Rock
        } == p2 -> Win

        else -> Loss
    }
}