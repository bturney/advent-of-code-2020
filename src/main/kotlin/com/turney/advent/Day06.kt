package com.turney.advent

/**
 * Day 6 - Custom Customs
 */
class Day06(input: String) {
    private val answers: List<List<String>> = input
        .split("\n\n")
        .map { it.lines().filter { line -> line.isNotBlank() } }


    fun solvePart1() = answers.sumBy { it.joinToString("").toSet().size }

    fun solvePart2() = 0

}
