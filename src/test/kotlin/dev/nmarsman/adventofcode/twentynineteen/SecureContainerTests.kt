package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SecureContainerTests: PuzzleTest
{
    override val puzzle = SecureContainer()

    /*
    111111 meets these criteria (double 11, never decreases).
    223450 does not meet these criteria (decreasing pair of digits 50).
    123789 does not meet these criteria (no double).
     */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertTrue(puzzle.convert(111111)
            .let { puzzle.adjacentSame(it) && puzzle.doesntDecrease(it) })
        Assertions.assertFalse(puzzle.convert(223450)
            .let { puzzle.adjacentSame(it) && puzzle.doesntDecrease(it) })
        Assertions.assertFalse(puzzle.convert(123789)
            .let { puzzle.adjacentSame(it) && puzzle.doesntDecrease(it) })
    }

    /*
    112233 meets these criteria because the digits never decrease and all repeated digits are exactly two digits long.
    123444 no longer meets the criteria (the repeated 44 is part of a larger group of 444).
    111122 meets the criteria (even though 1 is repeated more than twice, it still contains a double 22).
     */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertTrue(puzzle.convert(112233)
            .let { puzzle.doesntDecrease(it) && puzzle.containsGroupsOfTwo(it) })
        Assertions.assertFalse(puzzle.convert(123444)
            .let { puzzle.doesntDecrease(it) && puzzle.containsGroupsOfTwo(it) })
        Assertions.assertTrue(puzzle.convert(111122)
            .let { puzzle.doesntDecrease(it) && puzzle.containsGroupsOfTwo(it) })
    }
}