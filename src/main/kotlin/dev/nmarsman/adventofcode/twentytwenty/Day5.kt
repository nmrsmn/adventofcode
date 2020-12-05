package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle
import kotlin.math.pow

class Day5: Puzzle(2020, 5)
{
    override val input: List<Int>
        = data.trim().lines().map(::findSeatId)

    override fun part1()
        = input.maxOrNull()

    override fun part2()
        = (0 until (128 * 8)).toList()
            .filter { !input.contains(it) }
            .single { input.contains(it - 1) && input.contains(it + 1) }

    fun findSeatId(line: String): Int = line.let {
        val row = line.slice(0 .. 6).toList()
            .foldIndexed(0 .. 128, ::calculateRow)
        val column = line.slice(7 .. 9).toList()
            .foldIndexed(0 .. 7, ::calculateColumn)

        row.first * 8 + column.first
    }

    private fun calculateRow(index: Int, accumulator: IntRange, element: Char): IntRange {
        val step = 128 / 2.0.pow(index + 1).toInt()
        return when(element) {
            'F' -> accumulator.first until accumulator.first + step
            'B' -> accumulator.first + step .. accumulator.last
            else -> 1 .. 1
        }
    }

    private fun calculateColumn(index: Int, accumulator: IntRange, element: Char): IntRange {
        val step = 8 / 2.0.pow(index + 1).toInt()
        return when(element) {
            'L' -> accumulator.first until accumulator.first + step
            'R' -> accumulator.first + step .. accumulator.last
            else -> 1 .. 1
        }
    }

}

fun main() = Puzzle.mainify(Day5::class)