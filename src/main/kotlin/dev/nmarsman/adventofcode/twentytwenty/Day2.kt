package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle

class Day2: Puzzle(2020, 2)
{
    override val input: List<PasswordLine> = data.trim().lines().map(::parsePasswordLine)

    override fun part1()
        = validatePasswordLinesByCount(input)

    override fun part2()
        = validatePasswordLinesByIndex(input)

    fun parsePasswordLine(line: String): PasswordLine {
        val min = line.substringBefore('-').toInt()
        val max = line.substringBefore(' ').substringAfter('-').toInt()
        val char = line.substringBefore(':').substringAfter(' ').first()
        val password = line.substringAfterLast(' ')

        return PasswordLine(min, max, char, password)
    }

    fun validatePasswordLinesByCount(input: List<PasswordLine>) = input.filter { line ->
        line.password.count { it == line.char }.let { it >= line.min && it <= line.max }
    }.count()

    fun validatePasswordLinesByIndex(input: List<PasswordLine>) = input.filter { line ->
        listOf(line.password[line.min - 1], line.password[line.max - 1])
            .filter { it == line.char }
            .count() == 1
    }.count()
}

data class PasswordLine(val min: Int, val max: Int, val char: Char, val password: String)

fun main() = Puzzle.mainify(Day2::class)