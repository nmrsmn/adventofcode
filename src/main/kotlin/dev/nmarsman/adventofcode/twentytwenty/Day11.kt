package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle

typealias Seats = Array<CharArray>
typealias Seat = Pair<Int, Int>

class Day11: Puzzle(2020, 11)
{
    override val input = data.let(::format)

    fun format(input: String): Seats
        = input.trim().lines().map(String::toCharArray).toTypedArray()

    override fun part1()
        = findStableMap(input,4, this::countImmediateNeighbors)

    override fun part2()
        = findStableMap(input, 5, this::countFarNeighbors)

    fun findStableMap(input: Seats, tolerance: Int, count: (Seats, Seat) -> Int): Int
        = generateSequence(input) { it.next(tolerance, count) }
            .zipWithNext()
            .first { it.first.contentDeepEquals(it.second) }
            .first
            .occupied()

    fun countImmediateNeighbors(seats: Seats, seat: Seat): Int
        = neighboors
            .map { it + seat }
            .filter { it in seats }
            .count { seats[it.first][it.second] == '#' }

    fun countFarNeighbors(seats: Seats, seat: Seat): Int
        = neighboors
            .mapNotNull { findSeatOnVector(seats, seat, it) }
            .count { it == '#' }

    private fun findSeatOnVector(seats: Seats, seat: Seat, vector: Seat): Char?
        = generateSequence(seat + vector) { it + vector }
            .map { if (it in seats) seats[it.first][it.second] else null }
            .first { it == null || it != '.' }

    private fun Seats.next(tolerance: Int, count: (Seats, Seat) -> Int): Seats
        = mapIndexed { x, row ->
            row.mapIndexed { y, state ->
                val occupied = count(this, Seat(x, y))
                when {
                    state == 'L' && occupied == 0 -> '#'
                    state == '#' && occupied >= tolerance -> 'L'
                    else -> state
                }
            }.toCharArray()
        }.toTypedArray()

    private operator fun Seats.contains(seat: Seat): Boolean
        = seat.first in indices && seat.second in first().indices

    private operator fun Seat.plus(other: Seat): Seat
        = Seat(first + other.first, second + other.second)

    private fun Seats.occupied(): Int
        = sumBy { it.count { seat -> seat == '#' } }

    companion object
    {
        // @formatter: off
        private val neighboors = sequenceOf(
            -1 to -1, -1 to  0, -1 to  1,
             0 to -1,            0 to  1,
             1 to -1,  1 to  0,  1 to  1
        )
        // @formatter: on
    }
}

fun main() = Puzzle.mainify(Day11::class)