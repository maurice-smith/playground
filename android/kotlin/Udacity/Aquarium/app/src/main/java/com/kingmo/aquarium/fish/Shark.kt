package com.kingmo.aquarium.fish

class Shark(fishColor: FishColor = GreyColorProvider): FishAction, FishColor by fishColor {
    override fun eat() {
        println("Eat other fish!!! NOM")
    }
}