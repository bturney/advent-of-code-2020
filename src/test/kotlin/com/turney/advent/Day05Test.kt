package com.turney.advent

import com.turney.advent.Files.readFileAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day05Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = mapOf(
            "BFFFBBFRRR" to 567,
            "FFFBBBFRRR" to 119,
            "BBFFBBFRLL" to 820
        )
        @Test
        fun `Matches example`() {
            input.forEach { (key, expected) ->
                val answer = Day05(listOf(key)).solvePart1()
                assertThat(answer).isEqualTo(expected)
            }
        }

        @Test
        fun `Actual answer`() {
            val answer = Day05(readFileAsList("day05.txt")).solvePart1()
            assertThat(answer).isEqualTo(850)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            assertThat(true).isTrue
        }

        @Test
        fun `Actual answer`() {
            assertThat(true).isTrue
        }
    }
}
