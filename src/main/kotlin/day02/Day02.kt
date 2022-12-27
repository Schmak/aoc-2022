package day02

import day02.Action.*
import day02.Result.*
import utils.readFile

private val actions = mapOf('A' to Rock, 'B' to Paper, 'C' to Scissors, 'X' to Rock, 'Y' to Paper, 'Z' to Scissors)
private val results = mapOf('X' to Loss, 'Y' to Draw, 'Z' to Win)
private val wins = mapOf(Rock to Scissors, Paper to Rock, Scissors to Paper)
private val loses = mapOf(Rock to Paper, Paper to Scissors, Scissors to Rock)

fun part1(input: List<Pair<Action, Char>>): Int =
    input.map { (p1, p2) -> Round(p1, actions[p2]!!) }
        .sumOf { it.result.value + it.p2.value }

fun part2(input: List<Pair<Action, Char>>): Int =
    input.map { (p1, result) -> InverseRound(p1, results[result]!!) }
        .sumOf { it.result.value + it.p2.value }

fun parseInput(lines: List<String>) = lines.map { actions[it[0]]!! to it[2] }

fun main() {
    val input = parseInput(readFile("02"))
    println(part1(input))
    println(part2(input))
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
        loses[p1] == p2 -> Win
        else -> Loss
    }
}

data class InverseRound(
    val p1: Action,
    val result: Result,
) {
    val p2: Action = when (result) {
        Draw -> p1
        Loss -> wins[p1]!!
        Win -> loses[p1]!!
    }
}