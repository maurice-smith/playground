package com.kingmo.aquarium.extra

const val MAX_BOOK_LIMIT = 4

class Book(val title: String, val author: String, var publishedYear: Int = -1, var pageCount: Int = 0) {
    var timesBorrowed = 0;

    fun getBookInfo(): Pair<String, String> = Pair(title, author)

    fun getBookInfoWithYear(): Triple<String, String, Int> = Triple(title, author, publishedYear)

    fun canBorrow() = timesBorrowed < MAX_BOOK_LIMIT

    fun borrow() {
        timesBorrowed++
    }

    fun printUrl() {
        println("${BASE_URL}${title}.html")
    }

    companion object {
        const val BASE_URL = "https://www.books.com/"
    }
}

fun Book.getWeight() = pageCount * 1.5
fun Book.tornPages(pagesTorn: Int) {
    pageCount -= pagesTorn
}

fun main(args: Array<String>) {

    val myBook = Book("IT", "Stephen King")
    println("Book Info: ${myBook.getBookInfo().first} by ${myBook.getBookInfo().second}")

    myBook.publishedYear = 1986

    println("Book Info: ${myBook.getBookInfoWithYear().first} by ${myBook.getBookInfoWithYear().second}" +
            " published ${myBook.getBookInfoWithYear().third}")


    val allBooks: Set<String> = setOf("Hamlet", "Romeo & Juliet", "Stuff")

    val library: Map<String, Set<String>> = mapOf("William" to allBooks)

    println("Library contains Hamlet: ${library.any { it.value.contains("Hamlet") }}")


    val moreBooks = mutableMapOf("Terry Mac" to "Waiting to Exhale")
    //println("Books by Bell Hooks ${moreBooks.get("Bell Hooks")}")
    moreBooks.getOrPut("Bell Hooks") {"Black Women Are Great"}

    println(moreBooks)

    myBook.printUrl()

    val wwZ = Book("World War Z", "Mel Brooks, Jr.", 2000, 250)
    println("${wwZ.title} calculated weight: ${wwZ.getWeight()}")
    wwZ.tornPages(100)
    println("Ne weight with pages torn ${wwZ.getWeight()}" )
}