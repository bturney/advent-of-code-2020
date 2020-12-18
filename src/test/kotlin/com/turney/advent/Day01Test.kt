package com.turney.advent

import com.turney.advent.Files.readFileAsListOfInt
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {

    private val input = listOf(1721, 979, 366, 299, 675, 1456)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).productOfPair()
            assertThat(answer).isEqualTo(514_579)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day01(readFileAsListOfInt("day01.txt")).productOfPair()
            assertThat(answer).isEqualTo(980_499)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).productOfTriple()
            assertThat(answer).isEqualTo(241_861_950)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day01(readFileAsListOfInt("day01.txt")).productOfTriple()
            assertThat(answer).isEqualTo(200_637_446)
        }
    }

}
