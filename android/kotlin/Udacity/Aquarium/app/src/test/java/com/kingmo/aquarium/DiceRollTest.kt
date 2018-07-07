package com.kingmo.aquarium

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class DiceRollTest {
    @Test
    fun testLambda1() {
        val rollDice: (Int) -> Int = { it ->
            if (it == 0) {
                0
            } else {
                Random().nextInt(12) + 1
            }
         }
        println(rollDice(5))
    }

    @Test
    fun testLambda2() {
        val rollDice2 = { it: Int ->
            if (it == 0) {
                0
            } else {
                Random().nextInt(it) + 1
            }
        }(4)

        println(rollDice2)
        gamePlay(rollDice2)

    }

    fun gamePlay(rollDiceFunction: Int) {
        println(rollDiceFunction)
    }
}