package dev.nmarsman.adventofcode.utils

/**
 * Sequence
 */

fun <T> Sequence<T>.without(element: T) = filter { it != element }

fun <T> Sequence<T>.pairs(): Sequence<Pair<T, T>> = zipWithNext()
fun <T> Sequence<T>.triples(): Sequence<Triple<T, T, T>> = sequence {
    forEach { first ->
        without(first).forEach { second ->
            without(first).without(second).forEach { third ->
                yield(Triple(first, second, third))
            }
        }
    }
}