package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TwelveOTwoProgramAlarmTests: PuzzleTest
{
    override val puzzle = TwelveOTwoProgramAlarm()

    /*
    1,0,0,0,99 becomes 2,0,0,0,99 (1 + 1 = 2).
    2,3,0,3,99 becomes 2,3,0,6,99 (3 * 2 = 6).
    2,4,4,5,99,0 becomes 2,4,4,5,99,9801 (99 * 99 = 9801).
    1,1,1,4,99,5,6,0,99 becomes 30,1,1,4,2,5,6,0,99.
     */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(intArrayOf(2, 0, 0, 0, 99),
            puzzle.process(intArrayOf(1, 0, 0, 0, 99)))
        Assertions.assertEquals(intArrayOf(2, 3, 0, 6, 99),
            puzzle.process(intArrayOf(2, 3, 0, 3, 99)))
        Assertions.assertEquals(intArrayOf(2, 4, 4, 5, 99, 9801),
            puzzle.process(intArrayOf(2, 4, 4, 5, 99, 0)))
        Assertions.assertEquals(intArrayOf(30, 1, 1, 4, 2, 5, 6, 0, 99),
            puzzle.process(intArrayOf(1, 1, 1, 4, 99, 5, 6, 0, 99)))
    }

    /*
    No examples given
     */
    @Test
    override fun `part two examples`() = Unit
}