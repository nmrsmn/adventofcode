package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import dev.nmarsman.adventofcode.utils.pairs
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day10Tests: PuzzleTest
{
    override val puzzle = Day10()

    private val input = """
16
10
15
5
1
11
7
19
6
12
4
    """.let { puzzle.format(it) }

    private val largeInput = """
28
33
18
42
31
14
46
20
48
47
24
23
49
45
19
38
39
11
1
32
25
35
8
17
7
9
4
2
34
10
3
    """.let { puzzle.format(it) }

    /*
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(35, puzzle.splitByJoltageDifference(input))
        Assertions.assertEquals(220, puzzle.splitByJoltageDifference(largeInput))
    }

    /*

    */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(62, input)
        Assertions.assertEquals(62, largeInput)
    }
}