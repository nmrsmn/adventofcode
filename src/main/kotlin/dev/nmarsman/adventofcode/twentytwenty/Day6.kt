package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle

class Day6: Puzzle(2020, 6)
{
    override val input
        = data.trim().let(::format)

    fun format(input: String) = input.trim()
        .split("\n\n")
        .map { it.lines().map(String::toSet) }

    override fun part1()
        = countAnswersByAny(input)

    override fun part2()
        = countAnswersByAll(input)

    fun countAnswersByAny(input: List<List<Set<Char>>>) =
        input.sumBy { group -> group.reduce { acc, set -> acc.union(set) }.size }

    fun countAnswersByAll(input: List<List<Set<Char>>>) =
        input.sumBy { group -> group.reduce { acc, set -> acc.intersect(set) }.size }
}

fun main() = Puzzle.mainify(Day6::class)