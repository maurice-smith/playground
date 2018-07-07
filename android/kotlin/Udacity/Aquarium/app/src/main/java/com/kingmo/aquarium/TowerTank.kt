package com.kingmo.aquarium

import kotlin.math.PI

class TowerTank (): Aquarium() {
    override var water: Double = volume * 0.8

    override var volume: Int
        set(value) {height = (value * 1000) / (width * height)}
        get() = (width * height * length / 1000 * PI).toInt()
}