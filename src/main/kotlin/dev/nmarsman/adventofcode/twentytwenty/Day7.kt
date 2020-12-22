package dev.nmarsman.adventofcode.twentytwenty

import dev.nmarsman.adventofcode.Puzzle

class Day7: Puzzle<Map<String, List<List<String>>>>(2020, 7)
{
    override fun format(input: String) = input.trim().lines().map { line ->
        val (key, value) = line.split(" bags contain ")

        key to value.replace(".", "").split(",")
            .map { it.replace("(bags?)".toRegex(), "").trim().split(" ", limit = 2) }
    }.toMap()

    override fun part1()
        = countCanContainShinyGoldBag(input)

    override fun part2()
        = countContents("shiny gold", input)

    fun countCanContainShinyGoldBag(rules: Map<String, List<List<String>>>)
        = rules.filter { canContainShinyGoldBag(it.key, rules) }.count()

    fun countContents(bag: String, rules: Map<String, List<List<String>>>): Int = rules[bag]?.sumBy { contents ->
        val count = contents.first().replace("no", "0").toInt()
        count + count * countContents(contents.last(), rules)
    } ?: 0

    fun canContainShinyGoldBag(bag: String, rules: Map<String, List<List<String>>>): Boolean
        = rules[bag]?.any { it.contains("shiny gold") || canContainShinyGoldBag(it.last(), rules) } ?: false
}

fun main() = Puzzle.mainify(Day7::class)