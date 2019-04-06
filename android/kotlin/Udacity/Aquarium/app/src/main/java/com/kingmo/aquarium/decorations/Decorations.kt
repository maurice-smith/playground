package com.kingmo.aquarium.decorations

// Data classes
fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val rockDeck = Decorations("granite")
    println(rockDeck)

    val slate1 = Decorations("slate")
    println(slate1)

    val slate2 = Decorations("slate")
    println(slate2)

    println("rockDeck==slate1: ${rockDeck == slate1}")
    println("slate1==slate2: ${slate1.equals(slate2)}")

    val slate3 = slate1.copy()
    println("slate1==slate3: ${slate1 == slate3}")

    val dec2 = Decorations2("slate", "wood", "diver")
    println(dec2)

    val (rock, wood, diver) = dec2
    println(rock)
    println(wood)
    println(diver)

}


data class Decorations(val rocks: String)

data class Decorations2(val rocks: String, val wood: String, val diver: String)