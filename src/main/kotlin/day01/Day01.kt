package day01

import java.io.File


/*
find the two entries that sum to 2020 and then multiply those two numbers together.

For example, suppose your expense report contained the following:

1721
979
366
299
675
1456

In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
 */
const val TARGET = 2020

fun main() {
    val intList = Day01.readFile("src/main/resources/day01.csv")

    val partOne = Day01.solvePart1(intList)
    println("Part One's answer is $partOne")

    val partTwo = Day01.solvePart2(intList)
    println("Part Two's answer is $partTwo")
}

object Day01 {
    fun readFile(fileName: String): List<Int> = File(fileName).readLines().map { it.toInt() }

    /**
     * Sort the input array
     * Loop through every element in the list (call this a)
     * Skip idx + 1 entries we've already reviewed
     * Drop elements in the sequence that are below the TARGET
     * Take a single entry. Because the elements are sorted it will either be our answer or it will be out of range
     * Determine if the pair of values == TARGET
     * If they are, multiply them together. If not, return null
     * Select the first element that the sequence produces
     */
    fun solvePart1(intList: List<Int>): Int {
        val input = intList.sorted()
        return input
            .mapIndexedNotNull { idx, a ->
                input
                    .drop(idx + 1)
                    .dropWhile { a + it < TARGET }
                    .take(1)
                    .firstOrNull { a + it == TARGET }
                    ?.let { a * it }
            }.first()
    }

    /**
     * Pretty much the same solution as Part 1, just with another loop
     */
    fun solvePart2(intList: List<Int>): Int {
        val input = intList.sorted()
        return input
            .mapIndexedNotNull { aIdx, a ->
                input
                    .drop(aIdx + 1)
                    .mapIndexedNotNull { bIdx, b ->
                        input
                            .drop(bIdx + 1)
                            .dropWhile { a + b + it < TARGET }
                            .take(1)
                            .firstOrNull { a + b + it == TARGET }
                            ?.let { a * b * it }
                    }.firstOrNull()
            }.first()
    }
}
