package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle
import dev.nmarsman.adventofcode.utils.pairs

class Day9: Puzzle<List<Long>>(2020, 9)
{
    override fun format(input: String): List<Long>
        = input.trim().lines().map(String::toLong)

    private var deviation: Long = 0L

    override fun part1()
        = findFirstDeviationOriginal(input).also { deviation = it }

    override fun part2()
        = findEncryptionWeakness(input, deviation)

    fun findFirstDeviation(input: List<Long>, preamble: Int = 25): Long
        = input.windowed(preamble + 1)
               .first { !it.isValidTail() }
               .last()

    fun findFirstDeviationOriginal(input: List<Long>, preamble: Int = 25): Long = input.slice(0 until preamble).toMutableList().let { previous ->
        input.slice(preamble until input.size).forEach {
            if (!previous.findCombination(it))
                return@let it

            previous.removeAt(0)
            previous.add(it)
        }

        return 0L
    }

    fun findEncryptionWeakness(input: List<Long>, target: Long): Long
        = input.subListSumsTo(target).sorted().let { it.first() + it.last() }

    fun findEncryptionWeaknessOriginal(input: List<Long>, target: Long): Long
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

        error("No sublist sums to $target")
    }

    private fun List<Long>.isValidTail()
        = take(size - 1).pairs().any { it.first + it.second == last() }

    private fun MutableList<Long>.findCombination(target: Long): Boolean
        = this.asSequence().pairs().map { it.first + it.second }.contains(target)

    private fun List<Long>.subListSumsTo(target: Long): List<Long>
    {
        forEachIndexed { start, value ->
            var end = start
            var sum = value
            while (sum < target)
            {
                sum += this[++end]
                if (sum == target)
                {
                    return subList(start, end + 1)
                }
            }
        }
        error("No sublist sums to $target")
    }
}

fun main() = Puzzle.mainify(Day9::class)