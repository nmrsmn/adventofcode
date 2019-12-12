package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.Puzzle
import dev.nmarsman.adventofcode.twentynineteen.IntCode.Program

class Day5: Puzzle(2019, 5)
{
    override val input: IntArray
        = data.trim().split(',').map { it.toInt() }.toIntArray()

    override fun part1()
        = Program(input.copyOf(), 1).run().output.last()

    override fun part2()
        = Program(input.copyOf(), 5).run().output.last()
}

fun main() = Puzzle.mainify(Day5::class)