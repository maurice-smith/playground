package com.kingmo.aquarium.spice

import org.junit.Assert.*
import org.junit.Test

class SimpleSpiceTest {
    @Test
    fun shouldPrintSpiceNameAndHeat() {
        val spice = SimpleSpice("curry", "mild")
        print("Spice: ${spice.name} Heat Level: ${spice.heatLevel}")
    }

    @Test
    fun createListOfSpices() {
        val spiceList: List<Spice> = listOf(Spice("curry"),
                Spice("pepper", "medium"),
                Spice("ghost pepper", "xHot"))

        val lessSpicyList: List<Spice> = spiceList.filter { it.heatLevel <= 7 }
        assertEquals(lessSpicyList.size, 2)
    }

    @Test
    fun shouldCreateSaltSpice() {
        assertEquals(0, Spice.makeSalt().heatLevel)
    }
}