package day02

import java.io.File

fun main() {
    val fileContents = Day02.readFile("src/main/resources/day02.csv")
    val data = Day02.parseData(fileContents)

    val part1Count = data.count { it.validPart1 }
    println("Part One's answer is $part1Count")

    val part2Count = data.count { it.validPart2 }
    println("Part Two's answer is $part2Count")
}

object Day02 {
    // TODO Refactor file reading into utility class. I have feeling I'm gonna need it...
    fun readFile(fileName: String): List<String> = File(fileName).readLines()

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
