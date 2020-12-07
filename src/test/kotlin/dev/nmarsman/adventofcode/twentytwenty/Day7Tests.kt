package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day7Tests: PuzzleTest
{
    override val puzzle = Day7()

    private val input = """
light red bags contain 1 bright white bag, 2 muted yellow bags.
dark orange bags contain 3 bright white bags, 4 muted yellow bags.
bright white bags contain 1 shiny gold bag.
muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags.
    """.let { puzzle.format(it) }

    private val secondInput = """
shiny gold bags contain 2 dark red bags.
dark red bags contain 2 dark orange bags.
dark orange bags contain 2 dark yellow bags.
dark yellow bags contain 2 dark green bags.
dark green bags contain 2 dark blue bags.
dark blue bags contain 2 dark violet bags.
dark violet bags contain no other bags.
    """.let { puzzle.format(it) }

    /*
    In this example, the sum of these counts is 3 + 3 + 3 + 1 + 1 = 11.
    */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(4, puzzle.countCanContainShinyGoldBag(input))
    }

    /*

    */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(32, puzzle.countContents("shiny gold", input))
        Assertions.assertEquals(126, puzzle.countContents("shiny gold", secondInput))
    }
}