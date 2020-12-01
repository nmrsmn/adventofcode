package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle
import dev.nmarsman.adventofcode.utils.pairs
import dev.nmarsman.adventofcode.utils.triples

class Day1: Puzzle(2020, 1)
{
    override val input: Sequence<Int>
        = data.trim().lines().map { it.toInt() }.sorted().asSequence()

    override fun part1()
        = input.pairs()
            .first { it.first + it.second == 2020 }
            .let { it.first * it.second }

    override fun part2()
        = input.triples()
            .first { it.first + it.second + it.third == 2020 }
            .let { it.first * it.second * it.third }
}

fun main() = Puzzle.mainify(Day1::class)