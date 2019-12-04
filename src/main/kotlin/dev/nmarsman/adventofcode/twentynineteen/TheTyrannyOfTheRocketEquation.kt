package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.Puzzle
import kotlin.math.floor
import kotlin.math.max

/**
 * TheTyrannyOfTheRocketEquation
 *
 * See [Year 2019, Day 1](https://adventofcode.com/2019/day/1)
 */
class TheTyrannyOfTheRocketEquation: Puzzle(2019, 1)
{
    override val input: List<Double>
        get() = data.trim().lines().map { it.toDouble() }

    override fun part1()
        = input
            .map(::calculateExtraFuel)
            .sum()

    override fun part2()
        = input
            .map(::calculateCompoundExtraFuel)
            .sum()

    fun calculateExtraFuel(mass: Double): Double
        = floor(mass / 3) - 2

    fun calculateCompoundExtraFuel(mass: Double): Double
    {
        var accumulator = calculateExtraFuel(mass)
        var extra = accumulator
        while (extra > 0)
        {
            extra = max(calculateExtraFuel(extra), 0.0)
            accumulator += extra
        }

        return accumulator
    }
}

fun main() = Puzzle.mainify(TheTyrannyOfTheRocketEquation::class)