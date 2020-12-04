package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle

class Day4: Puzzle(2020, 4)
{
    override val input: List<String> = format(data)

    fun format(input: String) = input.trim()
        .split("\n\n")
        .map { it.replace("\n", " ") }
        .filter { it.isNotBlank() }

    override fun part1()
        = validatePassportLine(input, false)

    override fun part2()
        = validatePassportLine(input, true)

    fun validatePassportLine(lines: List<String>, validateField: Boolean)
        = lines.filterNot {
            val map = it.split(" ").map {
                val (key, value) = it.split(":")
                key to value
            }.toMap()
            validations
                .map { map.containsKey(it.key) && (!validateField || it.value.invoke(map[it.key]!!)) }
                .any { !it }
        }.count()

    private val validations = mapOf<String, (String) -> Boolean>(
        "byr" to { value -> value.toInt() in 1920 .. 2002 },
        "iyr" to { value -> value.toInt() in 2010 .. 2020 },
        "eyr" to { value -> value.toInt() in 2020 .. 2030 },
        "hgt" to { value -> validateHeight(value) },
        "hcl" to { value -> value.matches("^#[0-9a-z]{6}$".toRegex()) },
        "ecl" to { value -> value in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") },
        "pid" to { value -> value.matches("^[0-9]{9}$".toRegex()) },
    )

    private fun validateHeight(height: String) = when(height.takeLast(2)) {
        "cm" -> height.take(height.length - 2).toInt() in 150 .. 193
        "in" -> height.take(height.length - 2).toInt() in 59 .. 76
        else -> false
    }
}

fun main() = Puzzle.mainify(Day4::class)