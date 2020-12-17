package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day14Tests: PuzzleTest
{
    override val puzzle = Day14()

    private val input = """
mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
mem[8] = 11
mem[7] = 101
mem[8] = 0
    """.let { puzzle.format(it) }

    private val inputVersion2 = """
mask = 000000000000000000000000000000X1001X
mem[42] = 100
mask = 00000000000000000000000000000000X0XX
mem[26] = 1
    """.let { puzzle.format(it) }

    /*
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(165, puzzle.sumOfMemory(input))
    }

    /*

    */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(208, puzzle.sumOfMemoryVersion2(inputVersion2))
    }
}