package com.turney.advent

fun main() {
    val skiSlope = Files.readFileAsList("src/main/resources/day03.txt")
    Day03(skiSlope).apply {
        val part1Answer = solvePart1()
        println("Part One's answer is $part1Answer")
        val part2Answer = solvePart2()
        println("Part Two's answer is $part2Answer")
    }
}

internal class Day03(private val skiSlope: List<String>) {

    private val width = skiSlope.first().length
    private val height = skiSlope.size

    // Override the + operator for Pair
    // This isn't strictly necessary but it makes the code a bit cleaner below I think
    private operator fun Pair<Int, Int>.plus(that: Pair<Int, Int>) =
        Pair(this.first + that.first, this.second + that.second)

    /*
    Override the contains method for List to check for a tree
    Represented by a '#'
    Because the pattern of trees repeats we can use the modulus operator
    to calculate our index given the true width
    */
    private operator fun List<String>.contains(location: Pair<Int, Int>) =
        this[location.second][location.first % width] == '#'

    // Calculate the coordinates of our path given a slope
    private fun getPath(slope: Pair<Int, Int>): Sequence<Pair<Int, Int>> =
        generateSequence(Pair(0, 0)) { prev ->
            (prev + slope).takeIf { next -> next.second < height }
        }

    private fun countTreesOnSlope(slope: Pair<Int, Int>) =
        getPath(slope).count { it in skiSlope }

    fun solvePart1(): Int = countTreesOnSlope(3 to 1)

    fun solvePart2() = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
        .map { countTreesOnSlope(it).toLong() }
        .reduce { a, b -> a * b }
}



