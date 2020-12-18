package com.turney.advent

/**
 * Day 5 - Binary Boarding
 */
class Day05(private val input: List<String>) {
    // The pattern can be read as vanilla binary. This converts the text pattern to a binary pattern
    private fun seatId(pattern: String) =
        pattern.map { if (it in setOf('B', 'R')) '1' else '0' }.joinToString("").toInt(2)

    fun solvePart1() = input.map { seatId(it) }.maxOrNull() ?: throw IllegalStateException("No answer")

    fun solvePart2() =
        input.map { seatId(it) }
            .sorted()
            .zipWithNext() // creates a list of pairs for each adjacent element
            .first { it.second - it.first != 1 } // take the first pair that is not adjacent
            .first + 1 // take the first element of the pair and add 1 to get our seat


}
