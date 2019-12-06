package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.Puzzle
import dev.nmarsman.adventofcode.utils.Point

class CrossedWires: Puzzle(2019, 3)
{
    override val input: List<String>
        = data.trim().lines()

    private val intersections: Set<Point>
        = input
            .map(::convert)
            .map(::convertToPoint)
            .let { (first, second) -> first.intersect(second) }

    override fun part1()
        = part1(input)

    fun part1(input: List<String>)
        = input
            .map(::convert)
            .map(::convertToPoint)
            .let { (first, second) -> first.intersect(second) }
            .map { it.manhatten() }
            .min()

    override fun part2()
        = part2(input)

    fun part2(input: List<String>)
        = input
            .map(::convert)
            .map(::convertToPoint)
            .map(::intersectWithSteps)
            .let { (first, second) -> first.map { it.value + second.getValue(it.key) }.min() }

    fun convert(directions: String): List<Pair<Char, Int>>
        = directions
            .split(",")
            .map { it[0] to it.substring(1).toInt() }


    fun convertToPoint(directions: List<Pair<Char, Int>>): List<Point>
    {
        var current = Point(0, 0)
        var points = mutableListOf<Point>()

        directions.forEach()
        {
            (direction, steps) -> repeat(steps)
            {
                current += direction
                points.add(current)
            }
        }

        return points
    }

    fun intersectWithSteps(points: List<Point>): Map<Point, Int>
        = points
            .mapIndexed { index, point -> point to index + 1 }
            .filter { intersections.contains(it.first) }.toMap()
}

fun main() = Puzzle.mainify(CrossedWires::class)