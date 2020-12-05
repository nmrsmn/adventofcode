package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day5Tests: PuzzleTest
{
    override val puzzle = Day5()

    private val input = listOf(
        "BFFFBBFRRR",
        "FFFBBBFRRR",
        "BBFFBBFRLL")

    /*
    BFFFBBFRRR: row 70, column 7, seat ID 567.
    FFFBBBFRRR: row 14, column 7, seat ID 119.
    BBFFBBFRLL: row 102, column 4, seat ID 820.
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(357, puzzle.findSeatId("FBFBBFFRLR"))
        Assertions.assertEquals(567, puzzle.findSeatId(input[0]))
        Assertions.assertEquals(119, puzzle.findSeatId(input[1]))
        Assertions.assertEquals(820, puzzle.findSeatId(input[2]))
    }

    /*

    */
    @Test
    override fun `part two examples`()
    {

    }
}