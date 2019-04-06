package com.kingmo.aquarium.spices

data class SpiceContainer(val spice: Spice) {
    var label: String = ""
        get() = "${spice.name} Label"

}