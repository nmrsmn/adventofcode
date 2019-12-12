package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Tests: PuzzleTest
{
    override val puzzle = Day1()

    /*
    For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
    For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
    For a mass of 1969, the fuel required is 654.
    For a mass of 100756, the fuel required is 33583.
     */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(2.0, puzzle.calculateExtraFuel(12.0))
        Assertions.assertEquals(2.0, puzzle.calculateExtraFuel(14.0))
        Assertions.assertEquals(654.0, puzzle.calculateExtraFuel(1969.0))
        Assertions.assertEquals(33583.0, puzzle.calculateExtraFuel(100756.0))
    }

    /*
    A module of mass 14 requires 2 fuel. This fuel requires no further fuel (2 divided by 3 and rounded down is 0,
    which would call for a negative fuel), so the total fuel required is still just 2.

    At first, a module of mass 1969 requires 654 fuel. Then, this fuel requires 216 more fuel (654 / 3 - 2).
    216 then requires 70 more fuel, which requires 21 fuel, which requires 5 fuel, which requires no further fuel.
    So, the total fuel required for a module of mass 1969 is 654 + 216 + 70 + 21 + 5 = 966.

    The fuel required by a module of mass 100756 and its fuel is: 33583 + 11192 + 3728 + 1240 + 411 + 135 + 43 + 12 + 2 = 50346.
     */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(2.0, puzzle.calculateCompoundExtraFuel(14.0))
        Assertions.assertEquals(966.0, puzzle.calculateCompoundExtraFuel(1969.0))
        Assertions.assertEquals(50346.0, puzzle.calculateCompoundExtraFuel(100756.0))
    }
}