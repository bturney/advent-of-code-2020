package com.turney.advent

/**
 * Day 2 - Password Philosophy
 *
 * Problem:
 * Part 1
 * ======
 * Given a list of passwords and the policy of each password when it was set, find how many passwords are valid.
 *
 * For example, suppose you have the following list:
 *
 * 1-3 a: abcde
 * 1-3 b: cdefg
 * 2-9 c: ccccccccc
 *
 * Each line gives the password policy and then the password. The password policy indicates the lowest and highest
 * number of times a given letter must appear for the password to be valid. For example, 1-3 a means that the password
 * must contain a at least 1 time and at most 3 times.
 *
 * In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b,
 * but needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the limits
 * of their respective policies.
 *
 * Part 2
 * ======
 * Each policy actually describes two positions in the password, where 1 means the first character, 2 means the second
 * character, and so on. Exactly one of these positions must contain the given letter. Other occurrences of the letter
 * are irrelevant for the purposes of policy enforcement.
 * Given the same example list from above:
 * 1-3 a: abcde is valid: position 1 contains a and position 3 does not.
 * 1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
 * 2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
 *
 * How many passwords are valid according to the new interpretation of the policies?
 */
class Day02(input: List<String>) {

    private val data = input.map { PasswordRow.of(it) }

    fun solvePart1() = data.count { it.validPart1 }

    fun solvePart2() = data.count { it.validPart2 }

    data class PasswordRow(val range: IntRange, val letter: Char, val password: String) {
        val validPart1 = password.count { it == letter } in range

        val validPart2 = (password[range.first - 1] == letter) xor (password[range.last - 1] == letter)

        companion object {
            private val pattern = """^(\d+)-(\d+) (\w): (.+)$""".toRegex()

            fun of(input: String): PasswordRow {
                val (min, max, letter, password) = pattern.find(input)!!.destructured
                return PasswordRow(min.toInt()..max.toInt(), letter.first(), password)
            }
        }
    }
}
