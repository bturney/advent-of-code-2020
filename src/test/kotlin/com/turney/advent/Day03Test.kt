package com.turney.advent

import com.turney.advent.Files.readFileAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
internal class Day03Test {

    private val input = listOf(
        "..##.......",
        "#...#...#..",
        ".#....#..#.",
        "..#.#...#.#",
        ".#...##..#.",
        "..#.##.....",
        ".#.#.#....#",
        ".#........#",
        "#.##...#...",
        "#...##....#",
        ".#..#...#.#"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day03(input).solvePart1()
            assertThat(answer).isEqualTo(7)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day03(readFileAsList("day03.txt")).solvePart1()
            assertThat(answer).isEqualTo(195)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day03(input).solvePart2()
            assertThat(answer).isEqualTo(336)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day03(readFileAsList("day03.txt")).solvePart2()
            assertThat(answer).isEqualTo(3_772_314_000)
        }
    }
}
