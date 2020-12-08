package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day8Tests: PuzzleTest
{
    override val puzzle = Day8()

    private val input = """
nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6
    """.let { puzzle.format(it) }

    /*
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(5, puzzle.findAccumulatorValueBeforeInfiniteLoop(input))
    }

    /*

    */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(8, puzzle.findAccumulatedValueAfterTermination(input))
    }
}