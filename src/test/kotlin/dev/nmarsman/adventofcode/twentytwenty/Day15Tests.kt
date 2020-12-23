package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day15Tests: PuzzleTest
{
    override val puzzle = Day15()

    /*
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(436,
            puzzle.playMemoryGame(listOf(0, 3, 6)))

        Assertions.assertEquals(1,
            puzzle.playMemoryGame(listOf(1, 3, 2)))
        Assertions.assertEquals(10,
            puzzle.playMemoryGame(listOf(2, 1, 3)))
        Assertions.assertEquals(27,
            puzzle.playMemoryGame(listOf(1, 2, 3)))
        Assertions.assertEquals(78,
            puzzle.playMemoryGame(listOf(2, 3, 1)))
        Assertions.assertEquals(438,
            puzzle.playMemoryGame(listOf(3, 2, 1)))
        Assertions.assertEquals(1836,
            puzzle.playMemoryGame(listOf(3, 1, 2)))
    }

    /*

    */
    @Test
    override fun `part two examples`() = Unit
}