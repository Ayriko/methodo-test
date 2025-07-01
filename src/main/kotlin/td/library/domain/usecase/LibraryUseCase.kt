package td.library.domain.usecase

import td.library.domain.model.Book

class LibraryUseCase {
    private val books = mutableListOf<Book>()

    fun listAllBooks(): List<Book> {
        books.sortBy { it.title }
        return books
    }

    fun addBook(title: String, author: String): Book {
        val book = Book(title, author)
        books.add(book)
        return book
    }
}