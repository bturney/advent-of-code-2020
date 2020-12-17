package day02

import Files

fun main() {
    val fileContents = Files.readFileAsList("src/main/resources/day02.csv")
    val data = Day02.parseData(fileContents)

    val part1Count = data.count { it.validPart1 }
    println("Part One's answer is $part1Count")

    val part2Count = data.count { it.validPart2 }
    println("Part Two's answer is $part2Count")
}

internal object Day02 {
    fun parseData(input: List<String>): List<PasswordRecord> = input.map { PasswordRecord.of(it) }

}

data class PasswordRecord(val range: IntRange, val letter: Char, val password: String) {
    companion object {
        private val pattern = """^(\d+)-(\d+) (\w): (.+)$""".toRegex()

        fun of(input: String): PasswordRecord {
            val (min, max, letter, password) = pattern.find(input)!!.destructured
            return PasswordRecord(min.toInt()..max.toInt(), letter.first(), password)
        }
    }

    val validPart1 = password.count { it == letter } in range

    val validPart2 = (password[range.first - 1] == letter) xor (password[range.last - 1] == letter)
}
