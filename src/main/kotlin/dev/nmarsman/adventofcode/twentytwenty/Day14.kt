package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle
import dev.nmarsman.adventofcode.utils.toBinary

class Day14: Puzzle<List<String>>(2020, 14)
{
    override fun format(input: String)
        = input.trim().lines()

    override fun part1()
        = sumOfMemory(input)

    override fun part2()
        = sumOfMemoryVersion2(input)

    fun sumOfMemory(input: List<String>): Long = with(mutableMapOf<Long, Long>())
    {
        var mask = DEFAULT_MASK
        input.forEach { instruction ->
            if (instruction.startsWith("mask"))
            {
                mask = instruction.substringAfter(" = ")
            }
            else
            {
                val address = instruction.substringAfter("[").substringBefore("]").toLong()
                val value = instruction.substringAfter(" = ")
                this[address] = value maskedWith mask
            }
        }
        values.sum()
    }

    fun sumOfMemoryVersion2(input: List<String>): Long = with(mutableMapOf<Long, Long>())
    {
        var mask = DEFAULT_MASK
        input.forEach { instruction ->
            if (instruction.startsWith("mask"))
            {
                mask = instruction.substringAfter(" = ")
            }
            else
            {
                val unmaskedAddress = instruction.substringAfter("[").substringBefore("]")
                val value = instruction.substringAfter(" = ").toLong()
                unmaskedAddress.generateAddressMasks(mask).forEach { address ->
                    this[address] = value
                }
            }
        }
        values.sum()
    }

    private infix fun String.maskedWith(mask: String): Long
        = toBinary(36).zip(mask).map { (value, mask) ->
            mask.takeUnless { it == 'X' } ?: value
        }.joinToString("").toLong(2)

    private fun String.generateAddressMasks(mask: String): List<Long> = with(mutableListOf(toBinary(36).toCharArray()))
    {
        mask.forEachIndexed { index, bit ->
            when (bit)
            {
                '1' -> forEach { it[index] = '1' }
                'X' -> {
                    forEach { it[index] = '1' }
                    addAll(map { it.copyOf().apply { this[index] = '0' } })
                }
            }
        }
        map { it.joinToString("").toLong(2) }
    }

    companion object
    {
        private const val DEFAULT_MASK = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
    }
}

fun main() = Puzzle.mainify(Day14::class)