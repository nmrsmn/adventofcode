package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day13Tests: PuzzleTest
{
    override val puzzle = Day13()

    private val input = """
939
7,13,x,x,59,x,31,19
    """.let { puzzle.format(it) }

    /*
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(295, puzzle.findEarliestRoute(input))
    }

    /*

    */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(1068781L,
            puzzle.findEarliestConsecutiveTimestamp(input.second))

        Assertions.assertEquals(3417L,
            puzzle.findEarliestConsecutiveTimestamp(listOf("17", "x", "13", "19")))

        Assertions.assertEquals(754018L,
            puzzle.findEarliestConsecutiveTimestamp(listOf("67", "7", "59", "61")))

        Assertions.assertEquals(779210L,
            puzzle.findEarliestConsecutiveTimestamp(listOf("67", "x", "7", "59", "61")))

        Assertions.assertEquals(1261476L,
            puzzle.findEarliestConsecutiveTimestamp(listOf("67", "7", "x", "59", "61")))

        Assertions.assertEquals(1202161486L,
            puzzle.findEarliestConsecutiveTimestamp(listOf("1789", "37", "47", "1889")))
    }
}