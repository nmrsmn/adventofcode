package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.PuzzleTest
import dev.nmarsman.adventofcode.twentynineteen.IntCode.Program
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day5Tests: PuzzleTest
{
    override val puzzle = Day5()

    /*
    Input = 1

    3,0,4,0,99 outputs 1
    1002,4,3,4,33 outputs 0
     */
    @Test
    override fun `part one examples`()
    {
        Assertions.assertEquals(listOf(1),
            Program(intArrayOf(3, 0, 4, 0, 99), 1).run().output)

        Assertions.assertEquals(emptyList<Int>(),
            Program(intArrayOf(1002, 4, 3, 4, 33), 1).run().output)
    }

    /*
    Input = 1

    3,9,8,9,10,9,4,9,99,-1,8 outputs 0
    3,9,7,9,10,9,4,9,99,-1,8 outputs 1
    3,3,1108,-1,8,3,4,3,99 outputs 0
    3,3,1107,-1,8,3,4,3,99 outputs 1
     */
    @Test
    override fun `part two examples`()
    {
        val options = listOf(
            intArrayOf(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8),
            intArrayOf(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8),

            intArrayOf(3, 3, 1108, -1, 8, 3, 4, 3, 99),
            intArrayOf(3, 3, 1107, -1, 8, 3, 4, 3, 99),

            intArrayOf(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9),
            intArrayOf(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1),
            intArrayOf(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31,
                       1106, 0, 36, 98, 0, 0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104,
                       999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99)
        )

        Assertions.assertEquals(0, Program(options[0].copyOf(), 1).run().output.last())
        Assertions.assertEquals(1, Program(options[0].copyOf(), 8).run().output.last())

        Assertions.assertEquals(1, Program(options[1].copyOf(), 1).run().output.last())
        Assertions.assertEquals(0, Program(options[1].copyOf(), 8).run().output.last())

        Assertions.assertEquals(1, Program(options[2].copyOf(), 8).run().output.last())
        Assertions.assertEquals(0, Program(options[2].copyOf(), 1).run().output.last())

        Assertions.assertEquals(1, Program(options[3].copyOf(), 7).run().output.last())
        Assertions.assertEquals(0, Program(options[3].copyOf(), 8).run().output.last())

        Assertions.assertEquals(0, Program(options[4].copyOf(), 0).run().output.last())
        Assertions.assertEquals(1, Program(options[4].copyOf(), 1).run().output.last())

        Assertions.assertEquals(0, Program(options[5].copyOf(), 0).run().output.last())
        Assertions.assertEquals(1, Program(options[5].copyOf(), 1).run().output.last())

        //Assertions.assertEquals( 999, Program(options[6].copyOf(), 7).run().output.last())
        Assertions.assertEquals(1000, Program(options[6].copyOf(), 8).run().output.last())
        Assertions.assertEquals(1001, Program(options[6].copyOf(), 9).run().output.last())
    }
}