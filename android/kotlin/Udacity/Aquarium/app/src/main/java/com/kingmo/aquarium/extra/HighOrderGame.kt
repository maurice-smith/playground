package com.kingmo.aquarium.extra

enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game {
    var path = mutableListOf(Directions.START)
    val north = {path.add(Directions.NORTH)}
    val south = {path.add(Directions.SOUTH)}
    val east = {path.add(Directions.EAST)}
    val west = {path.add(Directions.WEST)}
    val end = {
        path.add(Directions.END)
        println("Game Over")
        println(path)
        path.clear()
        false
    }

    fun move(where: () -> Unit) {
        where()
    }

    fun makeMove(direction: String?) {
        if (direction != null) {
            when(direction) {
                "n" -> move { north() }
                "s" -> move { south() }
                "e" -> move { east() }
                "w" -> move { west() }
                else -> move { end() }
            }
        } else {
            move { end() }
        }
    }
}

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val outList = mutableListOf<Int>()
    for(item in this) {
        if (block(item) == 0) {
            outList.add(item)
        }
    }
    return outList
}

fun main(args: Array<String>) {
    val myGame = Game()
//    println(myGame.path)
//
//    myGame.north()
//    myGame.south()
//    myGame.east()
//    myGame.west()

    //myGame.end()

    //println(myGame.path)

    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)

    println(numbers.divisibleBy { it.rem(3) })

    var shouldContinue = true
    while (shouldContinue) {
        print("Enter a direction: n/s/e/w:")
        myGame.makeMove(readLine())
    }
}