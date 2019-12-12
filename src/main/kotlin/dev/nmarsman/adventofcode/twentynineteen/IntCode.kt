package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.twentynineteen.IntCode.OpCode.*

class IntCode
{
    class Program(val memory: IntArray, val input: Int)
    {
        val output = mutableListOf<Int>()

        fun run(): Program
        {
            var pointer = 0
            while (true)
            {
                var code = values().find { it.code == memory[pointer] % 100 }
                    ?: throw IllegalStateException("Undefined opcode '${memory[pointer]}' supplied")

                pointer = handle(code, pointer, memory.slice(pointer + 1 .. pointer + code.params), modes(code, pointer)) ?: return this
            }
        }

        private fun handle(code: OpCode, pointer: Int, params: List<Int>, modes: List<Boolean>): Int?
        {
            fun get(index: Int) = if(modes[index]) params[index] else memory[params[index]]

            when (code)
            {
                INPUT      -> memory[params[0]] = input
                OUTPUT     -> output.add(memory[params[0]])

                ADD        -> memory[params[2]] = get(0) + get(1)
                MULTIPLY   -> memory[params[2]] = get(0) * get(1)

                JUMP_TRUE  -> if(get(0) != 0) return get(1)
                JUMP_FALSE -> if(get(0) == 0) return get(1)

                LESS_THAN  -> memory[params[2]] = if (get(0) < get(1)) 1 else 0
                EQUALS     -> memory[params[2]] = if (get(0) == get(1)) 1 else 0

                TERMINATE  -> return null
            }

            return pointer + code.params + 1
        }

        private fun modes(code: OpCode, pointer: Int): List<Boolean> = when(code)
        {
            INPUT, OUTPUT, TERMINATE -> listOf()

            else -> (memory[pointer] / 100).toString()
                .padStart(code.params, '0')
                .map { it == '1' }
                .reversed()
        }
    }

    enum class OpCode(val code: Int, val params: Int)
    {
        ADD(1, 3),
        MULTIPLY(2, 3),
        INPUT(3, 1),
        OUTPUT(4, 1),

        JUMP_TRUE(5, 2),
        JUMP_FALSE(6, 2),

        LESS_THAN(7, 3),
        EQUALS(8, 3),

        TERMINATE(99, 0)
    }
}