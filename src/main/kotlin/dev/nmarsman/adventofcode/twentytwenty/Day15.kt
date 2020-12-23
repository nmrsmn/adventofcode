package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle
import dev.nmarsman.adventofcode.utils.toBinary

class Day15: Puzzle<List<Int>>(2020, 15)
{
    override fun format(input: String): List<Int>
        = input.trim().split(",").map(String::toInt)

    override fun part1()
        = playMemoryGame(input)

    override fun part2()
        = playMemoryGame(input, 30000000)

    fun playMemoryGame(input: List<Int>, amount: Int = 2020): Int
    {
        var last = input.last()
        var seen = input.subList(0, input.lastIndex).withIndex()
            .associateTo(mutableMapOf()) { (index, value) -> value to index }

        for (index in input.lastIndex until amount - 1)
        {
            last = index - (seen.put(last, index) ?: index)
        }

        return last
    }


}

fun main() = Puzzle.mainify(Day15::class)