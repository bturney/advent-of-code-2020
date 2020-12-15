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
    val intList = readFile("src/main/resources/day1-1.csv")

    println("Part 1")
    run part1@{
        intList.forEach { if (findResultPart1(it, intList)) return@part1 }
    }

    println("Part 2")
    run part2@{
        intList.forEach { a ->
            intList.forEach { b ->
                if (findResultPart2(a, b, intList)) return@part2
            }
        }
    }

}


fun readFile(fileName: String): List<Int> = File(fileName).readLines().map { it.toInt() }

fun findResultPart1(candidate: Int, intList: List<Int>): Boolean {
    val secondCandidate = TARGET - candidate
    return if (intList.contains(secondCandidate)) {
        println("Found result $candidate * $secondCandidate = ".plus(candidate * secondCandidate))
        true
    } else false
}

/*
Find 3 entries that sum to 2020 and their product
 */
fun findResultPart2(a: Int, b: Int, intList: List<Int>): Boolean {
    val candidate = TARGET - (a + b)
    return if (intList.contains(candidate)) {
        println("Found result $a * $b * $candidate = ".plus(a * b * candidate))
        true
    } else false
}
