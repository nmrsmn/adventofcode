package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.Puzzle

class UniversalOrbitMap: Puzzle(2019, 6)
{
    override val input: Map<String, String>
        = data.trim().lines()
            .map { it.split(")") }
            .map { it.last() to it.first() }
            .toMap()

    private val root: String
        = input.values
            .filter { v -> input.keys.none { it == v } }
            .single()

    override fun part1()
        = input.keys.map { path(it).size - 1 }.sum()

    override fun part2(): Int
    {
        val you = path("YOU").toMutableList()
        val santa = path("SAN").toMutableList()

        while (you.first() == santa.first())
        {
            you.removeAt(0)
            santa.removeAt(0)
        }

        return you.size + santa.size - 2
    }

    private fun path(current: String): List<String>
        = if (current == root) listOf(root)
          else path(input.getValue(current)) + current
}

fun main() = Puzzle.mainify(UniversalOrbitMap::class)