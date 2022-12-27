package day03

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

class Day03KtTest {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(157)
    }

    companion object {
        private val input = readFile("03", type = "test")
    }
}