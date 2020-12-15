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
fun main() {
    val intList = readFile("src/main/resources/day1-1.csv")

    intList.forEach {
        if (findResult(it, intList)) return
    }
}


fun readFile(fileName: String): List<Int> = File(fileName).readLines().map { it.toInt() }

fun findResult(candidate: Int, intList: List<Int>): Boolean {
    val secondCandidate = 2020 - candidate
    return if (intList.contains(secondCandidate)) {
        println("Found result $candidate * $secondCandidate = ".plus(candidate * secondCandidate))
        true
    } else false
}
