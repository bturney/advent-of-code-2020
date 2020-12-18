package com.turney.advent

/**
 * Day 4 - Passport Processing
 *
 * Problem: https://adventofcode.com/2020/day/4
 */
class Day04(input: String) {

    private val passports = input.split("\n\n")

    fun solvePart1(): Int = passports.count { passport -> expectedFields.all { passport.contains(it) } }

    // Doesn't handle the case where we get an unexpected key in the input
    fun solvePart2(): Int = passports.count { passport -> fieldPatterns.all { it.containsMatchIn(passport) } }

    companion object {
        private val expectedFields =
            listOf("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:") // ignore "cit:" fields

        private val fieldPatterns = listOf(
            """\bpid:\d{9}\b""", // Exactly 9 digits
            """\bhcl:#[0-9a-f]{6}\b""", // a hex value for a color
            """\becl:(amb|blu|brn|gry|grn|hzl|oth)\b""", // exactly one of the defined options
            """\biyr:(201[0-9]|2020)\b""", // 2010 to 2020
            """\beyr:(202[0-9]|2030)\b""", // 2020 to 2030
            """\bbyr:(19[2-9][0-9]|200[0-2])\b""", // 1920 to 2002
            """\bhgt:((1([5-8][0-9]|9[0-3])cm)|((59|6[0-9]|7[0-6])in))\b""" // if cm: 150 to 193. if in: 59 to 76
        ).map { it.toRegex() }
    }
}
