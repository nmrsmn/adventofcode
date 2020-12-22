package dev.nmarsman.adventofcode.utils

import kotlin.math.absoluteValue

/**
 * String
 */

fun String.toBinary(length: Int = 8): String
    = toLong().toString(2).padStart(length, '0')

/**
 * List
 */

fun <T> List<T>.pairs(): List<Pair<T, T>>
    = asSequence().pairs().toList()

/**
 * Sequence
 */

fun <T> Sequence<T>.without(element: T) = filter { it != element }

fun <T> Sequence<T>.pairs(): Sequence<Pair<T, T>> = sequence {
    forEach { first ->
        without(first).forEach { second ->
            yield(Pair(first, second))
        }
    }
}

fun <T> Sequence<T>.triples(): Sequence<Triple<T, T, T>> = sequence {
    forEach { first ->
        without(first).forEach { second ->
            without(first).without(second).forEach { third ->
                yield(Triple(first, second, third))
            }
        }
    }
}

/**
 * Point
 */

typealias Point = Pair<Int, Int>

val Point.x get() = first
val Point.y get() = second

operator fun Point.plus(other: Point): Point
    = Point(x + other.x, y + other.y)

operator fun Point.times(by: Int): Point
    = Point(x * by, y * by)

infix fun Point.distanceTo(other: Point): Int
    = (x - other.x).absoluteValue + (y - other.y).absoluteValue

fun Point.rotateLeft(): Point
    = Point(y * -1, x)

fun Point.rotateRight(): Point
    = Point(y, x * -1)