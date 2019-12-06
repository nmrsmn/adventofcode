package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.Puzzle
import java.lang.IllegalStateException

class TwelveOTwoProgramAlarm: Puzzle(2019, 2)
{
    override val input: IntArray
        = data.trim().split(',').map { it.toInt() }.toIntArray()

    override fun part1()
        = input.copyOf()
            .also { it[1] = 12 }
            .also { it[2] = 2 }
            .let { process(it) }
            .let { it[0] }

    override fun part2(): Int
    {
        for (noun in 0 until 99)
        {
            for (verb in 0 until 99)
            {
                val program = input.copyOf()
                    .also { it[1] = noun }
                    .also { it[2] = verb }
                    .let { process(it) }

                if (program[0] == 19690720)
                {
                    return 100 * noun + verb
                }
            }
        }

        return 0
    }

    fun process(codes: IntArray): IntArray
    {
        for (index in codes.indices step 4)
        {
            val code = codes[index]

            if (code == 99)
                break

            val first = codes[codes[index + 1]]
            val second = codes[codes[index + 2]]

            val result = when (code)
            {
                1 -> first + second
                2 -> first * second

                else -> throw IllegalStateException("Wrong opcode")
            }

            codes[codes[index + 3]] = result
        }

        return codes
    }
}

fun main() = Puzzle.mainify(TwelveOTwoProgramAlarm::class)