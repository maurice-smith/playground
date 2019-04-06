package com.kingmo.aquarium.spices

import org.junit.Assert.*
import org.junit.Test

class SpiceContainerTest {
    @Test
    fun shouldReturnSpiceLabel() {
        val spiceContainer = SpiceContainer(Curry("5"))

        assertEquals("Curry Label", spiceContainer.label)
    }

    @Test
    fun shouldCreateSpiceContainers() {
        val pepperContainer = SpiceContainer(Pepper("7"))

        assertEquals("Pepper Label", pepperContainer.label)
    }
}