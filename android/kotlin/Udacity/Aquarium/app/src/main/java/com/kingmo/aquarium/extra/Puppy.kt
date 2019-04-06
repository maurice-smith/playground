package com.kingmo.aquarium.extra

import kotlin.random.Random

class Puppy {
    fun playWithBook(book: Book) {
        book.tornPages(Random(100).nextInt())
    }
}