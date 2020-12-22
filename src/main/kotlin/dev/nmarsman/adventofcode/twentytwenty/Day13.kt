package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle

class Day13: Puzzle<Pair<Int, List<String>>>(2020, 13)
{
    override fun format(input: String)
        = input.trim().lines().let {
            it.first().toInt() to it.last().split(",")
        }

    override fun part1()
        = findEarliestRoute(input)

    override fun part2()
        = findEarliestConsecutiveTimestamp(input.second)

    fun findEarliestRoute(input: Pair<Int, List<String>>): Int
        = input.second.filter { it != "x" }
            .map(String::toInt)
            .map { it to ((input.first / it) + 1) * it }
            .sortedBy { it.second }
            .first()
            .let { (it.second - input.first) * it.first }

    fun findEarliestConsecutiveTimestamp(input: List<String>): Long
        = input.mapIndexedNotNull { index, line -> if (line == "x") null else index to line.toLong() }.let { indexedLines ->
            var step = indexedLines.first().second
            var time = 0L
            indexedLines.drop(1).forEach { (offset, line) ->
                while ((time + offset) % line != 0L) {
                    time += step
                }
                step *= line
            }
            time
        }
}

fun main() = Puzzle.mainify(Day13::class)