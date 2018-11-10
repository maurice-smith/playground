package com.kingmo.aquarium.fish

//interface delegation. consider using it instead of abstract class.
class Shark(fishColor: FishColor = GreyColorProvider): FishAction, FishColor by fishColor {
    override fun eat() {
        println("Eat other fish!!! NOM")
    }
}