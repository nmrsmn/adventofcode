package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.Puzzle
import dev.nmarsman.adventofcode.utils.Point

class SecureContainer: Puzzle(2019, 4)
{
    override val input
        = data.trim().split("-")
            .map(Integer::parseInt)
            .let { (first, second) -> (first .. second) }
            .map(::convert)

    override fun part1()
        = input
            .filter(::doesntDecrease)
            .filter(::adjacentSame)
            .count()

    override fun part2()
        = input
            .filter(::doesntDecrease)
            .filter(::containsGroupsOfTwo)
            .count()

    fun convert(code: Int): List<Int>
        = code.toString().map(Character::getNumericValue)

    fun adjacentSame(code: List<Int>): Boolean
        = (0 .. 4).any { code[it] == code[it + 1] }

    fun doesntDecrease(code: List<Int>): Boolean
        = (0 .. 4).none { code[it] > code[it + 1] }

    fun containsGroupsOfTwo(code: List<Int>): Boolean
        = code.groupBy { it }.any { it.value.count() == 2 }
}

fun main() = Puzzle.mainify(SecureContainer::class)