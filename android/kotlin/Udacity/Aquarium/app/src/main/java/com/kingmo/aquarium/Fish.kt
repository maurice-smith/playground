package com.kingmo.aquarium

class Fish (val friendly: Boolean = true, volumeNeeded: Int) {
    val size: Int

    init {
        size = if (friendly) volumeNeeded  else volumeNeeded * 2
    }
}