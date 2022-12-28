package day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

class Day04KtTest {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(2)
    }

    companion object {
        private val input = parseInput(readFile("04", type = "test"))
    }
}