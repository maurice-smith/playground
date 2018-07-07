package com.kingmo.aquarium.book

open class Book () {
    private var currentPage: Int = 0

    open fun readPage() {
        currentPage++
    }
}