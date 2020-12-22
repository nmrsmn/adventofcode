package dev.nmarsman.adventofcode.twentynineteen

import dev.nmarsman.adventofcode.Puzzle
import java.lang.IllegalStateException
import kotlin.math.abs

class Day3: Puzzle<List<String>>(2019, 3)
{
    override fun format(input: String)
        = input.trim().lines()

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
            .map { intersectWithSteps(it, input) }
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

    private fun intersections(input: List<String>): Set<Point>
        = input
            .map(::convert)
            .map(::convertToPoint)
            .let { (first, second) -> first.intersect(second) }

    fun intersectWithSteps(points: List<Point>, input: List<String>): Map<Point, Int>
        = with(intersections(input)) {
            points
                .mapIndexed { index, point -> point to index + 1 }
                .filter { this.contains(it.first) }.toMap()
        }

}

fun main() = Puzzle.mainify(Day3::class)

data class Point(val x: Int, val y: Int): Comparable<Point>
{
    operator fun plus(direction: Char) = when(direction.toLowerCase())
    {
        'u' -> Point(x, y + 1)
        'd' -> Point(x, y - 1)
        'l' -> Point(x - 1, y)
        'r' -> Point(x + 1, y)

        else -> throw IllegalStateException("Cannot map direction '$direction'")
    }

    override fun compareTo(other: Point): Int
        = if (y == other.y) x.compareTo(other.x) else y.compareTo(other.y)

    fun manhatten(other: Point = Point(0, 0))
        = abs(x - other.x) + abs(y - other.y)

    override fun toString()
        = "Point [$x, $y]"
}