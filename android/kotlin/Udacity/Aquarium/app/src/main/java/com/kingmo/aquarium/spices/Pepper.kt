package com.kingmo.aquarium.spices

class Pepper(override var spiciness: String,
             color: SpiceColor = BlackSpiceColor): Spice("Pepper", color) {
    override fun prepareSpice() {
        println("Preppin Pepper")
    }
}