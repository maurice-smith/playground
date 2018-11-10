package com.kingmo.aquarium.spices

import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test

class CurryTest {

    @Test
    fun shouldPrintCurryDetails() {
        val curry = Curry("hot")
        curry.printDetails()
    }

    @Test
    fun shouldPrepareCurry() {
        val curry = Curry("hot")
        curry.prepareSpice()
    }

    @Test
    fun shouldReturnCorrectSpiceColor() {
        val curry = Curry("mild")
        assertEquals(curry.color, "YELLOW")
    }
}