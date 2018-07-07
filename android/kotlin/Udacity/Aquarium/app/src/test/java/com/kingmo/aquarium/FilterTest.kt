package com.kingmo.aquarium

import org.junit.Assert.*
import org.junit.Test


class FilterTest {
    val spices: List<String> = listOf("curry", "pepper", "cayenne", "ginger", "red curry",
            "green curry", "red pepper")

    @Test
    fun testFilter() {
        val expectedList: List<String> = listOf("poor", "pineapples")
        val list = listOf("poor", "pineapples", "meat", "berries")
        val filteredList: List<String> = list.filter { it[0] == 'p' }
        assertEquals(expectedList, filteredList)
    }

    @Test
    fun testFilterByLengthExercise() {
        val expectedList: List<String> = listOf("green curry", "red curry", "curry")
        val filteredList = spices.filter { it.contains("curry") }.sortedByDescending { it.length }
        assertEquals(expectedList, filteredList)
    }

    @Test
    fun testFilterBySpiceStartWith() {
        val expectedList: List<String> = listOf("cayenne")
        val filteredList: List<String> = spices.filter { it[0] == 'c' && it[it.length - 1] == 'e' }
        assertEquals(expectedList, filteredList)
    }

    @Test
    fun testFilterBySpiceStartWith2() {
        val expectedList: List<String> = listOf("cayenne")
        val filteredList: List<String> = spices.filter { it.startsWith("c") && it.endsWith("e") }
        assertEquals(expectedList, filteredList)
    }

    @Test
    fun testFilterFirstThreeElements() {
        val expectedList: List<String> = listOf("curry", "cayenne")
        val filteredList: List<String> = spices.take(3).filter { it.startsWith("c") }
        assertEquals(expectedList, filteredList)
    }

    @Test
    fun quizLambdaQ1() {
        val random1 = random()
        val random2 = {random()}
        print(random1)
        println(random2)
    }

    fun random() {
        println("random")
    }
}