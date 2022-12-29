package day06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

class Day06KtTest {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(7)
    }

    companion object {
        private val input = parseInput(readFile("06", type = "test"))
    }
}