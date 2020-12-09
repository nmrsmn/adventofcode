package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import dev.nmarsman.adventofcode.utils.pairs
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day9Tests: PuzzleTest
{
    override val puzzle = Day9()

    private val input = """
35
20
15
25
47
40
62
55
65
95
102
117
150
182
127
219
299
277
309
576
    """.let { puzzle.format(it) }

    /*
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(127L, puzzle.findFirstDeviation(input, 5))
    }

    /*

    */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(62, puzzle.findEncryptionWeakness(input, 127L))
    }
}