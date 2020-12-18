package com.turney.advent

/**
 * Day 1 - Report Repair
 *
 * Problem:
 * Part 1
 * ======
 * Find the two entries that sum to 2020 and then multiply those two numbers together.
 * For example, suppose your expense report contained the following:
 * 1721
 * 979
 * 366
 * 299
 * 675
 * 1456
 * In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
 *
 * Part 2
 * ======
 * Find three numbers in your expense report that meet the same criteria.
 */

class Day01(data: List<Int>) {
    companion object {
        private const val TARGET = 2020
    }

    private val input = data.sorted()

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
    fun productOfPair() =
        input.mapIndexedNotNull { index, a ->
            input
                .drop(index + 1)
                .dropWhile { a + it < TARGET }
                .take(1)
                .firstOrNull { a + it == TARGET }
                ?.let { a * it }
        }.first()

    /**
     * Pretty much the same solution as Part 1, just with another loop
     */
    fun productOfTriple() =
        input.mapIndexedNotNull { aIdx, a ->
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
