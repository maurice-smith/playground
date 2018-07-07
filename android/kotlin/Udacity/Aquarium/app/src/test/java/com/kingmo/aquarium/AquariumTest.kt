package com.kingmo.aquarium

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class AquariumTest {
    var aquarium: Aquarium = Aquarium()

    @Before
    fun setUp() {
    }

    @Test
    fun testPrintAquariumSpecs() {

        println("Length: ${aquarium.length}\nWidth: ${aquarium.width}\nHeight: ${aquarium.height}")
    }

    @Test
    fun testPrintVolume() {
        println("Aquarium Volume: ${aquarium.volume}")
    }

    @Test
    fun testVolumeSetter() {
        aquarium.volume = 5

        println("Aquarium Volume: ${aquarium.volume}")
    }

    @Test
    fun testSecondConstructor() {
        aquarium = Aquarium(9)
        println("# of Fish: ${aquarium.numberOfFish}")
    }
}