package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle
import dev.nmarsman.adventofcode.utils.*
import java.lang.IllegalArgumentException

typealias Instruction = Pair<Char, Int>
typealias Position = Pair<Int, Int>

class Day12: Puzzle<List<Instruction>>(2020, 12)
{
    override fun format(input: String): List<Instruction>
        = input.trim().lines().map { it.first() to it.substring(1).toInt() }

    override fun part1()
        = navigatePartOne(input)

    override fun part2()
        = navigatePartTwo(input)

    fun navigatePartOne(input: List<Instruction>): Int
        = input.fold(Ship()) { ship, instruction ->
            when (instruction.command) {
                'F' -> ship.forward(instruction.amount)
                'L' -> ship.turnLeft(instruction.amount / 90)
                'R' -> ship.turnRight(instruction.amount / 90)
                'N' -> ship.move(Direction.North, instruction.amount)
                'E' -> ship.move(Direction.East, instruction.amount)
                'S' -> ship.move(Direction.South, instruction.amount)
                'W' -> ship.move(Direction.West, instruction.amount)
                else -> throw IllegalArgumentException("Unsupported instruction: '$instruction'")
            }
        }.position distanceTo (0 to 0)

    fun navigatePartTwo(input: List<Instruction>): Int
    {
        var ship = Ship()
        var waypoint = Waypoint()
        input.forEach { instruction ->
            when (instruction.command) {
                'F' -> ship = ship.copy(position = ship.position + (waypoint.position * instruction.amount))
                'L' -> waypoint = waypoint.turnLeft(instruction.amount / 90)
                'R' -> waypoint = waypoint.turnRight(instruction.amount / 90)
                'N' -> waypoint = waypoint.move(Direction.North, instruction.amount)
                'E' -> waypoint = waypoint.move(Direction.East, instruction.amount)
                'S' -> waypoint = waypoint.move(Direction.South, instruction.amount)
                'W' -> waypoint = waypoint.move(Direction.West, instruction.amount)
                else -> throw IllegalArgumentException("Unsupported instruction: '$instruction'")
            }
        }
        return ship.position distanceTo (0 to 0)
    }
}

fun main() = Puzzle.mainify(Day12::class)

val Instruction.command get() = first
val Instruction.amount get() = second

data class Ship(val position: Position = 0 to 0, val facing: Direction = Direction.East)
{
    fun forward(amount: Int): Ship
        = copy(position = position + (facing.offset * amount))

    fun move(direction: Direction, amount: Int): Ship
        = copy(position = position + (direction.offset * amount))

    fun turnLeft(times: Int): Ship
        = (0 until times).fold(this) { ship, _ -> ship.copy(facing = ship.facing.turnLeft) }

    fun turnRight(times: Int): Ship
        = (0 until times).fold(this) { ship, _ -> ship.copy(facing = ship.facing.turnRight) }
}

data class Waypoint(val position: Position = -1 to 10)
{
    fun move(direction: Direction, amount: Int): Waypoint
        = Waypoint(position + (direction.offset * amount))

    fun turnLeft(times: Int): Waypoint
        = (0 until times).fold(this) { waypoint, _ -> Waypoint(waypoint.position.rotateLeft()) }

    fun turnRight(times: Int): Waypoint
        = (0 until times).fold(this) { waypoint, _ -> Waypoint(waypoint.position.rotateRight()) }
}

sealed class Direction
{
    abstract val turnLeft: Direction
    abstract val turnRight: Direction
    abstract val offset: Position

    operator fun invoke(direction: Char) = when(direction)
    {
        'N' -> North
        'S' -> South
        'E' -> East
        'W' -> West
        else -> throw IllegalArgumentException("No such direction '$direction'")
    }

    object North: Direction()
    {
        override val turnLeft = West
        override val turnRight = East
        override val offset: Position = -1 to 0
    }

    object East: Direction()
    {
        override val turnLeft = North
        override val turnRight = South
        override val offset: Position = 0 to 1
    }

    object South: Direction()
    {
        override val turnLeft = East
        override val turnRight = West
        override val offset: Position = 1 to 0
    }

    object West: Direction()
    {
        override val turnLeft = South
        override val turnRight = North
        override val offset: Position = 0 to -1
    }
}