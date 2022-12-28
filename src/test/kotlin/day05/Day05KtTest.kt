package day05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

class Day05KtTest {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo("CMZ")
    }

    @Test
    fun part2() {
        val actual = part2(input)
        assertThat(actual).isEqualTo("MCD")
    }

    companion object {
        private val input
            get() = parseInput(readFile("05", type = "test"))
    }
}