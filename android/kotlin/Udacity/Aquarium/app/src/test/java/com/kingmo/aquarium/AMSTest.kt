package com.kingmo.aquarium

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.math.exp

class AMSTest {
    val ams = AMS()
    val suggest = Suggest()

    @Test
    fun shouldPrintDayOfWeek() {
        ams.feedFish()
    }

    @Test
    fun shouldChangeWater() {
        ams.shouldChangeWater(day = "Monday")
    }

    @Test
    fun shouldReturnStayHomeSuggestion() {
        assertEquals("Stay home and read.", suggest.whatShouldIDoToday("sad"))
    }

    @Test
    fun shouldReturnGoWalkSuggestion() {
        assertEquals("go for a walk", suggest.whatShouldIDoToday("happy"))
    }
}