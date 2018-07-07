package com.kingmo.aquarium.fish

class ClownFish(): AquariumFish(), FishAction {
    override val color: String
        get() = "white"

    override fun eat() {
        println("Eat plankton!!! NOM!!")
    }
}