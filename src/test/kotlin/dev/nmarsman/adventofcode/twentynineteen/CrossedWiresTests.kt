package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.PuzzleTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CrossedWiresTests: PuzzleTest
{
    override val puzzle = CrossedWires()

    /*
    R8,U5,L5,D3
    U7,R6,D4,L4
    distance = 6

    R75,D30,R83,U83,L12,D49,R71,U7,L72
    U62,R66,U55,R34,D71,R55,D58,R83
    distance = 159

    R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
    U98,R91,D20,R16,D67,R40,U7,R15,U6,R7
    distance = 135
     */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(6, "R8,U5,L5,D3\nU7,R6,D4,L4"
            .lines().let { puzzle.first(it) })
        Assertions.assertEquals(159, "R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83"
            .lines().let { puzzle.first(it) })
        Assertions.assertEquals(135, "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
            .lines().let { puzzle.first(it) })
    }

    /*
    R8,U5,L5,D3
    U7,R6,D4,L4
    steps = 30

    R75,D30,R83,U83,L12,D49,R71,U7,L72
    U62,R66,U55,R34,D71,R55,D58,R83
    steps = 610

    R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
    U98,R91,D20,R16,D67,R40,U7,R15,U6,R7
    steps = 410
     */
    @Test
    override fun `part two examples`()
    {
        Assertions.assertEquals(30, "R8,U5,L5,D3\nU7,R6,D4,L4"
            .lines().let { puzzle.second(it) })
        Assertions.assertEquals(610, "R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83"
            .lines().let { puzzle.second(it) })
        Assertions.assertEquals(410, "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
            .lines().let { puzzle.second(it) })
    }
}