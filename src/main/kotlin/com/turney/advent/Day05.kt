package com.turney.advent

/**
 * Day 5 - Binary Boarding
 */
class Day05(private val input: List<String>) {
    private fun seatId(pattern: String) =
        pattern.map { if (it in setOf('B', 'R')) '1' else '0' }.joinToString("").toInt(2)

    fun solvePart1() = input.map { seatId(it) }.max()
}
