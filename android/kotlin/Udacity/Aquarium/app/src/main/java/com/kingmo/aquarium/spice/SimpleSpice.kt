package com.kingmo.aquarium.spice

class SimpleSpice (var name: String, var spiciness: String) {
    var heatLevel: Int = 0
        get() {
            return when(spiciness) {
                "mild" -> 5
                else -> 0
            }
        }
}