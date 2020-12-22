package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle

class Day10: Puzzle<List<Int>>(2020, 10)
{
    override fun format(input: String)
        = input.trim().lines().map(String::toInt).sorted()

    override fun part1()
        = splitByJoltageDifference(input)

    override fun part2() = with(longArrayOf(1, 0, 0, 0)) {
        input.fold(0) { previous, current ->
            val difference = current - previous
            copyInto(this, difference, 0, size - difference)
            fill(0, 0, difference)
            set(0, get(0) + sum())
            current
        }
        get(0)
    }

    fun splitByJoltageDifference(input: List<Int>): Int = with(IntArray(2) { 0 }) {
        input.fold(0) { previous, current ->
            when (current - previous) {
                1 -> set(0, get(0) + 1)
                3 -> set(1, get(1) + 1)
            }
            current
        }
        get(0) * (get(1) + 1)
    }
}

fun main() = Puzzle.mainify(Day10::class)