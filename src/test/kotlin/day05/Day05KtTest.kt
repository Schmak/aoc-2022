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

    companion object {
        private val input = parseInput(readFile("05", type = "test"))
    }
}