package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day12Tests: PuzzleTest
{
    override val puzzle = Day12()

    private val input = """
F10
N3
F7
R90
F11
    """.let { puzzle.format(it) }

    /*
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(25, puzzle.navigatePartOne(input))
    }

    /*

    */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(286, puzzle.navigatePartTwo(input))
    }
}