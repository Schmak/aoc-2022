package day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

class Day01KtTest {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(24000)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        assertThat(actual).isEqualTo(45000)
    }

    companion object {
        private val input = parseInput(readFile("01", type = "test"))
    }
}