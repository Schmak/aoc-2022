package day07

import day07.CommandWithResult.Cd
import day07.CommandWithResult.Ls
import utils.readFile

fun part1(input: Dir): Long =
    input.allDirs
        .map { it.totalSize }
        .filter { it <= 100_000 }
        .sum()

fun part2(input: Dir): Long {
    val threshold = input.totalSize - 40_000_000
    return input.allDirs
        .map { it.totalSize }
        .filter { it >= threshold }
        .min()
}

private const val CD = "$ cd "

fun parseInput(lines: List<String>): Dir = sequence {
    var result = emptyList<FsNode>()
    for (line in lines) {
        if (!line.startsWith("$")) {
            val (size, name) = line.split(" ")
            result +=
                if (size == "dir")
                    FsNode.Dir(name)
                else
                    FsNode.File(size.toLong())
        } else if (result.isNotEmpty()) {
            yield(Ls(result))
            result = emptyList()
        }
        if (line.startsWith(CD)) yield(Cd(line.removePrefix(CD)))
    }
    if (result.isNotEmpty()) yield(Ls(result))
}.let(::process)

fun process(commands: Sequence<CommandWithResult>): Dir {
    val root = Dir(parent = null)
    var pwd = root
    commands.forEach { cmd ->
        when (cmd) {
            is Cd -> {
                when (cmd.directory) {
                    "/" -> pwd = root
                    ".." -> pwd = requireNotNull(pwd.parent)
                    else -> {
                        pwd = pwd.dirs.getOrPut(cmd.directory) { Dir(parent = pwd) }
                    }
                }
            }

            is Ls -> pwd.filesSize += cmd.files.filterIsInstance<FsNode.File>().sumOf { it.size }
        }
    }
    return root
}

fun main() {
    val input = parseInput(readFile("07"))
    println(part1(input))
    println(part2(input))
}

sealed interface CommandWithResult {
    data class Cd(val directory: String) : CommandWithResult

    data class Ls(val files: List<FsNode>) : CommandWithResult
}

sealed interface FsNode {
    data class File(val size: Long) : FsNode
    data class Dir(val name: String) : FsNode
}

data class Dir(
    val parent: Dir?,
    val dirs: MutableMap<String, Dir> = mutableMapOf(),
    var filesSize: Long = 0,
) {
    val totalSize: Long by lazy {
        filesSize + dirs.values.sumOf { it.totalSize }
    }

    override fun toString(): String {
        return "Dir(size=$filesSize,dirs=$dirs)"
    }

    val allDirs: Sequence<Dir> = sequence {
        yield(this@Dir)
        dirs.values.forEach { yieldAll(it.allDirs) }
    }
}

