package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle
import dev.nmarsman.adventofcode.utils.pairs

class Day9: Puzzle(2020, 9)
{
    override val input = data.let(::format)

    fun format(input: String): List<Long>
        = input.trim().lines().map(String::toLong)

    override fun part1()
        = findFirstDeviation(input)

    override fun part2()
        = findEncryptionWeakness(input, 1721308972)

    fun findFirstDeviation(input: List<Long>, preamble: Int = 25) = input.slice(0 until preamble).toMutableList().let { previous ->
        input.slice(preamble until input.size).forEach {
            if (!previous.findCombination(it))
                return@let it

            previous.removeAt(0)
            previous.add(it)
        }
    }

    fun findEncryptionWeakness(input: List<Long>, target: Long): Long
    {
        var index = 0
        while(index < input.size)
        {
            val list = mutableListOf<Long>()
            let { input.slice(index until input.size).forEach {
                list.add(it)
                if (list.sum() >= target)
                    return@let
            }}

            if (list.sum() == target)
                return list.sorted().let { (it.minOrNull() ?: 0) + (it.maxOrNull() ?: 0) }

            index++
        }

        return 0L
    }

    private fun MutableList<Long>.findCombination(target: Long): Boolean
        = this.asSequence().pairs().map { it.first + it.second }.contains(target)
}

fun main() = Puzzle.mainify(Day9::class)