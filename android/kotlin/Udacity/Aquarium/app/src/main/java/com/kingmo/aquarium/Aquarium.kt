package com.kingmo.aquarium

class Aquarium (var width: Int = 20, var height: Int = 40, var length: Int = 100) {
    //custom setter and getter property that returns volume
    var volume: Int
        set(value) {height = (value * 1000) / (width * height)}
        get() = width * height * length / 100
    var water: Double = volume * .9
    var numberOfFish: Int = 0

    constructor(numberOfFish: Int): this() {
        this.numberOfFish = numberOfFish
    }
}