package com.kingmo.aquarium.book

class eBook(var title: String, var author: String, var format: String = "text"): Book() {
    private var wordCount: Int = 0

    override fun readPage() {
        wordCount += 250
    }
}