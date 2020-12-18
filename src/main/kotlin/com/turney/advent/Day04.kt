package com.turney.advent

/**
 * Day 4 - Passport Processing
 *
 * Problem: https://adventofcode.com/2020/day/4
 */
class Day04(input: String) {

    private val passports = input.split("\n\n")

    fun solvePart1() : Int = passports.count { passport -> expectedFields.all { passport.contains(it) } }

    companion object {
        private val expectedFields = listOf("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:") // ignore "cit:" fields
    }
}
