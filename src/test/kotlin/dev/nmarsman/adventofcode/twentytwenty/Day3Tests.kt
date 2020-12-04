package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day3Tests: PuzzleTest
{
    override val puzzle = Day3()

    private val input = listOf(
        "..##.......",
        "#...#...#..",
        ".#....#..#.",
        "..#.#...#.#",
        ".#...##..#.",
        "..#.##.....",
        ".#.#.#....#",
        ".#........#",
        "#.##...#...",
        "#...##....#",
        ".#..#...#.#")

    /*
    For example, suppose you have the following list:

    1-3 a: abcde
    1-3 b: cdefg
    2-9 c: ccccccccc

    In the above example, 2 passwords are valid. The middle password, cdefg, is not;
    it contains no instances of b, but needs at least 1. The first and third passwords
    are valid: they contain one a or nine c, both within the limits of their respective policies.
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(7,
            puzzle.countTrees(input))
    }

    /*
    Given the same example list from above:

    1-3 a: abcde is valid: position 1 contains a and position 3 does not.
    1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
    2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
    */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(336,
            puzzle.encounteredTrees(input))
    }
}