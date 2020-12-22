package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle

class Day8: Puzzle<List<Pair<String, Int>>>(2020, 8)
{
    override fun format(input: String): List<Pair<String, Int>> = input.trim().lines().map { line ->
        val (instruction, argument) = line.split(" ", limit = 2)
        instruction to argument.toInt()
    }

    override fun part1()
        = findAccumulatorValueBeforeInfiniteLoop(input)

    override fun part2()
        = findAccumulatedValueAfterTermination(input)

    fun findAccumulatorValueBeforeInfiniteLoop(input: List<Pair<String, Int>>): Int = with(mutableListOf<Pair<Int, Int>>()) {
        var index = 0
        var accumulator = 0
        while (none { it.first == index }) {
            val element = input[index]
            val original = index
            when (element.first) {
                "acc" -> {
                    accumulator += element.second
                    index++
                }
                "jmp" -> index += element.second
                "nop" -> index ++
            }
            add(original to accumulator)
        }

        return accumulator
    }

    fun findAccumulatedValueAfterTermination(input: List<Pair<String, Int>>)
        = input.asSequence()
            .mapIndexed { index, instruction -> index to instruction }
            .filter { it.second.first in listOf("nop", "jmp") }
            .map { findAccumulatedValue(switchInstruction(input, it.first)) }
            .filterNotNull().first()

    private fun findAccumulatedValue(input: List<Pair<String, Int>>): Int? = with(mutableListOf<Pair<Int, Int>>()) {
        var index = 0
        var accumulator = 0
        while (none { it.first == index } && index < input.size) {
            val element = input[index]
            val original = index
            when (element.first) {
                "acc" -> {
                    accumulator += element.second
                    index++
                }
                "jmp" -> index += element.second
                "nop" -> index ++
            }
            add(original to accumulator)
        }

        if (any { it.first == index})
            return null

        return accumulator
    }

    private fun switchInstruction(input: List<Pair<String, Int>>, index: Int)
        = input.toMutableList().also { it[index] = (if(it[index].first == "jmp") "nop" else "jmp") to it[index].second }

}

fun main() = Puzzle.mainify(Day8::class)