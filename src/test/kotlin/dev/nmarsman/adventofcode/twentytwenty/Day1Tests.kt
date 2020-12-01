package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Tests: PuzzleTest
{
    override val puzzle = Day1()

    /*
    For example, suppose your expense report contained the following: 1721, 979, 366, 299, 675, 1456

    In this list, the two entries that sum to 2020 are 1721 and 299.
    Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
     */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(514579,
            puzzle.findPair(sequenceOf(1721, 979, 366, 299, 675, 1456)))
    }

    /*
    Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
    Multiplying them together produces the answer, 241861950.
     */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(241861950,
            puzzle.findTriple(sequenceOf(1721, 979, 366, 299, 675, 1456)))
    }
}