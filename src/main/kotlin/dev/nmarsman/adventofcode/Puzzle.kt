package dev.nmarsman.adventofcode

import dev.nmarsman.adventofcode.utils.Input
import kotlin.reflect.KClass

import kotlin.reflect.full.primaryConstructor
import kotlin.system.measureTimeMillis

abstract class Puzzle(val year: Int, val day: Int)
{
    val identifier by lazy { "Advent of code ${year} - day ${day}" }

    val data: String by lazy()
    {
        Input.fetcher.fetch(year, day).execute().body() ?: ""
    }

    abstract val input: Any

    open fun part1(): Any? = null
    open fun part2(): Any? = null

    companion object
    {
        fun mainify(clazz: KClass<out Puzzle>)
        {
            val puzzle = clazz.primaryConstructor?.call()
                ?: throw IllegalStateException("Puzzle ${clazz.simpleName} should have a primary constructor")

            println(" ${puzzle.identifier}:\n" +
                    "-".repeat(puzzle.identifier.length + 3) + "\n")

            measureTimeMillis { println("Part one: ${puzzle.part1() ?: "Unresolved"}") }
                .also { println("Time: ${it}ms\n") }

            measureTimeMillis { println("Part two: ${puzzle.part2() ?: "Unresolved"}") }
                .also { println("Time: ${it}ms\n") }
        }
    }
}