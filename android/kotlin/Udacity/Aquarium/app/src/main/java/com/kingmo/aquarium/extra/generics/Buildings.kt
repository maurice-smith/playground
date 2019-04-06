package com.kingmo.aquarium.extra.generics

open class BaseBuildingMaterial(var numberNeeded: Int = 1)

class Wood: BaseBuildingMaterial(4)

class Brick: BaseBuildingMaterial(8)

class Building<out T: BaseBuildingMaterial>(private val buildingMaterial: T) {
    private val baseMaterialsNeeded = 100
    private val actualMaterialsNeeded
        get() = baseMaterialsNeeded * buildingMaterial.numberNeeded

    fun build() {
        println("${buildingMaterial::class.simpleName} material needs $actualMaterialsNeeded units")
    }
    fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
        if (building.actualMaterialsNeeded < 500) {
            println("Small building")
        } else {
            println("large building")
        }
    }
}


fun main(args: Array<String>) {
    val myBuilding = Building(Wood())

    myBuilding.build()

    myBuilding.isSmallBuilding(Building(Brick()))
}