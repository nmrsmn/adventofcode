package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import dev.nmarsman.adventofcode.utils.pairs
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day11Tests: PuzzleTest
{
    override val puzzle = Day11()

    private val input = """
L.LL.LL.LL
LLLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLLL
L.LLLLLL.L
L.LLLLL.LL
    """.let { puzzle.format(it) }

    /*
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(37, puzzle.findStableMap(input, 4, puzzle::countImmediateNeighbors))
    }

    /*

    */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(26, puzzle.findStableMap(input, 5, puzzle::countFarNeighbors))
    }
}