package dev.nmarsman.adventofcode

import dev.nmarsman.adventofcode.utils.Input
import kotlin.reflect.KClass

import kotlin.reflect.full.primaryConstructor
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

abstract class Puzzle<T: Any>(val year: Int, val day: Int)
{
    val identifier by lazy { "Advent of code ${year} - day ${day}" }

    private val data: String by lazy()
    {
        Input.fetcher.fetch(year, day).execute().body() ?: ""
    }

    val input: T
        get() = format(data)

    abstract fun format(input: String): T

    open fun part1(): Any? = null
    open fun part2(): Any? = null

    companion object
    {
        @OptIn(ExperimentalTime::class)
        fun mainify(clazz: KClass<out Puzzle<*>>)
        {
            val puzzle = clazz.primaryConstructor?.call()
                ?: throw IllegalStateException("Puzzle ${clazz.simpleName} should have a primary constructor")

            println(" ${puzzle.identifier}:\n" +
                    "-".repeat(puzzle.identifier.length + 3) + "\n")

            measureTimedValue { puzzle.part1() }
                .also { print("Part one: ${it.value ?: "Unresolved"}\n\n") }
                .also { print("Time\t: ") }
                .also { print("${format(it.duration)} (first run)\n\t\t  ") }
                .also { print(measureAverageTime { puzzle.part1() } + " (average)\n\n\n") }

            measureTimedValue { puzzle.part2() }
                .also { print("Part two: ${it.value ?: "Unresolved"}\n\n") }
                .also { print("Time\t: ") }
                .also { print("${format(it.duration)} (first run)\n\t\t  ") }
                .also { print(measureAverageTime { puzzle.part2() } + " (average)\n\n") }
        }

        @OptIn(ExperimentalTime::class)
        private fun measureAverageTime(iterations: Int = 20, block: () -> Unit): String
            = (0 .. iterations)
                .map { measureTimedValue { block() } }
                .map { it.duration.toLongNanoseconds() }
                .sum().div(iterations)
                .let { format(it) }

        @OptIn(ExperimentalTime::class)
        private fun format(duration: Duration, precision: Int = 4): String
            = format(duration.toLongNanoseconds())

        private fun format(nanotime: Long, precision: Int = 4): String
            = "${"%.${precision}f".format(nanotime / 1000000f)}ms"
    }
}