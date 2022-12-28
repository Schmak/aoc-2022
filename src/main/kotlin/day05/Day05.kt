package day05

import utils.readFile

fun part1(input: Input): String {
    for (step in input.program)
        input.stacks[step.from - 1].copyTo(input.stacks[step.to - 1], number = step.number)
    return input.fingerprint()
}

fun parseInput(lines: List<String>): Input {
    val divider = lines.indexOf("")
    check(divider > 0)
    return Input(
        stacks = parseStacks(lines.take(divider - 1)),
        program = lines.drop(divider + 1).map(::parseStep)
    )
}

private fun parseStacks(lines: List<String>): List<ArrayDeque<Char>> {
    val number = lines.maxOf { it.length + 1 } / 4
    val stacks = List(number) { ArrayDeque<Char>() }
    lines.forEach { line ->
        line.chunked(4).forEachIndexed { index, chunk ->
            val char = chunk[1]
            if (char != ' ')
                stacks[index].addFirst(char)
        }
    }
    return stacks
}

private fun parseStep(line: String): Step {
    val (number, from, to) = line.split(" ").mapNotNull(String::toIntOrNull)
    return Step(
        from = from,
        to = to,
        number = number,
    )
}

private fun <E> ArrayDeque<E>.copyTo(other: ArrayDeque<E>, number: Int) =
    repeat(number) { other.addLast(this.removeLast()) }

fun main() {
    val input = parseInput(readFile("05"))
    println(part1(input))
}

data class Input(
    val stacks: List<ArrayDeque<Char>>,
    val program: List<Step>
) {
    fun fingerprint() = String(stacks.map { it.last() }.toCharArray())
}

data class Step(
    val number: Int,
    val from: Int,
    val to: Int,
)