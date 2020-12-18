package com.turney.advent

/**
 * Day 3 - Toboggan Trajectory
 *
 * Problem: You know what? Just read it here: https://adventofcode.com/2020/day/3
 */
class Day03(private val skiSlope: List<String>) {

    private val width = skiSlope.first().length
    private val height = skiSlope.size

    fun solvePart1() = countTreesInPath(3 to 1)

    fun solvePart2() = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
        .map { countTreesInPath(it).toLong() }
        .reduce { a, b -> a * b }

    private fun countTreesInPath(slope: Pair<Int, Int>) =
        path(slope).count { it in skiSlope }

    private fun path(slope: Pair<Int, Int>): Sequence<Pair<Int, Int>> =
        generateSequence(Pair(0, 0)) { prev ->
            (prev + slope).takeIf { next -> next.second < height }
        }

    private operator fun Pair<Int, Int>.plus(that: Pair<Int, Int>) =
        Pair(this.first + that.first, this.second + that.second)

    private operator fun List<String>.contains(location: Pair<Int, Int>) =
        this[location.second][location.first % width] == '#'
}


