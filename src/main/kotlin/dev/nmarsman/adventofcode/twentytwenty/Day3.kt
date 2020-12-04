package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle

class Day3: Puzzle(2020, 3)
{
    override val input: List<String> = data.trim().lines()

    override fun part1()
        = countTrees(input)

    override fun part2()
        = encounteredTrees(input)

    fun encounteredTrees(lines: Collection<String>)
        = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
            .map { countTrees(lines, it.first, it.second) }
            .reduce { a, b -> a * b }

    fun countTrees(lines: Collection<String>, x: Int = 3, y: Int = 1)
        = lines
            .filterIndexed { index, line -> index % y == 0 && line[index / y * x % line.length] == '#' }
            .count().toLong()
}

fun main() = Puzzle.mainify(Day3::class)