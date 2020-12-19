package com.turney.advent

import com.turney.advent.Files.readFileAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day06Test {

    val input = """
            abc

            a
            b
            c

            ab
            ac

            a
            a
            a
            a

            b
        """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            val answer = Day06(input).solvePart1()
            assertThat(answer).isEqualTo(11)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day06(readFileAsText("day06.txt")).solvePart1()
            assertThat(answer).isEqualTo(6443)
        }
    }
}
