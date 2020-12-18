package com.turney.advent

import com.turney.advent.Files.readFileAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
internal class Day02Test {
    private val input = listOf(
        "1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day02(input).solvePart1()
            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day02(readFileAsList("day02.txt")).solvePart1()
            assertThat(answer).isEqualTo(622)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day02(input).solvePart2()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day02(readFileAsList("day02.txt")).solvePart2()
            assertThat(answer).isEqualTo(263)
        }
    }
}
