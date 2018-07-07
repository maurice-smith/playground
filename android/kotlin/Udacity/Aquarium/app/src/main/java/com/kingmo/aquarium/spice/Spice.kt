package com.kingmo.aquarium.spice

class Spice (val name: String, var spiciness: String = "mild") {
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

    init {
        println("Name: ${name}\nSpiciness: ${spiciness}\nHeat: ${heatLevel}\n")
    }

    // a way to mimic static functions
    companion object {
        fun makeSalt() = Spice("salt", "not spicy")
    }
}