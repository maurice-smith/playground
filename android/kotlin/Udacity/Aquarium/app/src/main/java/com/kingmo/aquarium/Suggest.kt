package com.kingmo.aquarium

class Suggest {
    fun shouldGoSwimming(temp: Int): Boolean = temp > 35
    fun isSadAndRainy(mood: String, weather: String, temp: Int): Boolean =
            mood == "sad" && weather == "rainy" && temp == 0
    fun isHappyWeather(mood: String, weather: String): Boolean = mood == "happy" && weather == "sunny"

    fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
        return when {
            isSadAndRainy(mood, weather, temperature) -> "stay in bed"
            shouldGoSwimming(temperature) -> "go swimming"
            isHappyWeather(mood, weather) -> "go for a walk"
            else -> "Stay home and read."
        }
    }
    fun main(args: Array<String>) {
        whatShouldIDoToday("sad")
    }
}