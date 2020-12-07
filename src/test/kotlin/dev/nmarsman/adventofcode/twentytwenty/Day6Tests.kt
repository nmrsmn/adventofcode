package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day6Tests: PuzzleTest
{
    override val puzzle = Day6()

    private val input = """
abc

a
b
c

ab
ac

a
a
a
a

b
    """.let { puzzle.format(it) }

    /*
    In this example, the sum of these counts is 3 + 3 + 3 + 1 + 1 = 11.
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(11, puzzle.countAnswersByAny(input))
    }

    /*

    */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(6, puzzle.countAnswersByAll(input))
    }
}