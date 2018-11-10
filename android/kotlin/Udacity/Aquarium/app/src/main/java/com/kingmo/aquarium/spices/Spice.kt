package com.kingmo.aquarium.spices

abstract class Spice (val name: String, color: SpiceColor): SpiceColor by color {
    abstract var spiciness: String
    abstract fun prepareSpice()

    var heatLevel: Int = 0
        get() {
            return when(spiciness) {
                "xHot" -> 15
                "hot" -> 10
                "medium" -> 7
                "mild" -> 5
                else -> 0
            }
        }

    fun printDetails() {
        println("Name: ${name}\nSpiciness: ${spiciness}\nHeat: ${heatLevel}\n")
    }

    // a way to mimic static functions
    companion object {
        //fun makeSalt() = Spice("salt", "not spicy")
    }
}