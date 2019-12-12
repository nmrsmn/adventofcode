package dev.nmarsman.adventofcode.utils

import java.lang.IllegalStateException
import kotlin.math.abs

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