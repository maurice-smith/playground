package com.kingmo.aquarium

import com.kingmo.aquarium.fish.RedColorProvider
import com.kingmo.aquarium.fish.Shark

open class Aquarium (var width: Int = 20, var height: Int = 40, var length: Int = 100) {
    //custom setter and getter property that returns volume
    open var volume: Int
        set(value) {height = (value * 1000) / (width * height)}
        get() = width * height * length / 100
    open var water: Double = volume * .9
    var numberOfFish: Int = 0

    constructor(numberOfFish: Int): this() {
        this.numberOfFish = numberOfFish
    }

    fun delegate() {
        val shark1: Shark = Shark()
        println("Shark1 color: ${shark1.color}")
        shark1.eat()


        val shark2: Shark = Shark(RedColorProvider)
        println("Shark2 color: ${shark2.color}")
        shark2.eat()
    }
}