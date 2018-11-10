package com.kingmo.aquarium.spices

class Curry(override var spiciness: String,
            color: SpiceColor = YellowSpiceColor): Spice("Curry", color), Grinder {

    override fun grind() {
        println("GrindIIIINNNNNN!!-Curry")
    }

    override fun prepareSpice() {
        grind()
    }
}