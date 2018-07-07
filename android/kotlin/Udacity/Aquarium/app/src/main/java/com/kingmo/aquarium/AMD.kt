package com.kingmo.aquarium

import java.util.*

class AMS {
    fun fitMoreFish(tankSize: Int,
                    currentFish: List<Int>,
                    fishSize: Int = 2,
                    hasDecorations: Boolean = true): Boolean {
        if (hasDecorations) {

        } else {

        }
        return false
    }
    fun dayOfTheWeek() {
        println("What day is it today?")
        println("today is: " + Calendar.getInstance().getDisplayName(Calendar.DAY_OF_WEEK,
                Calendar.LONG, Locale.getDefault()))
    }

    fun shouldChangeWater(day: String , temp: Int = 23, dirty: Int = 20): Boolean {
        return true
    }

    fun feedFish() {
        val day = randomDay()
        println("Today is $day and the fish eat ${fishFood(day)}")
    }

    fun fishFood(day: String) : String {

        return when(day) {
            "Monday" -> "pellets"
            "Tuesday" -> "bugs"
            "Wednesday" -> "crickets"
            "Thursday" -> "worms"
            "Friday" -> "flakes"
            "Saturday" -> "weed"
            "Sunday" -> "beer"
            else -> "fasting"
        }
    }

    fun randomDay(): String {
        val calendar: Calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_WEEK, Random().nextInt(7))

        return calendar.getDisplayName(Calendar.DAY_OF_WEEK,
                Calendar.LONG, Locale.getDefault())
    }

    fun main(args: Array<String>) {
        dayOfTheWeek()

        println("${if (args[0].toInt() < 12) "Good morning, Kotlin" else "Good night, Kotlin"}")
    }
}