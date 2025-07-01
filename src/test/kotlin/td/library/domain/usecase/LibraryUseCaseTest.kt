package td.library.domain.usecase

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LibraryUseCaseTest : FunSpec({
    test("ListAllBooks should return an empty list") {
        // Arrange
        val libraryUseCase = LibraryUseCase()

        // Act
        val books = libraryUseCase.listAllBooks()

        // Assert
        books shouldBe emptyList()
    }

    test("AddBook should return a book with the given title and author") {
        // Arrange
        val libraryUseCase = LibraryUseCase()
        val title = "Effective Kotlin"
        val author = "Marcin Moskala"

        // Act
        val book = libraryUseCase.addBook(title, author)

        // Assert
        book.title shouldBe title
        book.author shouldBe author
    }

    test("ListAllBooks should return a list with the added book") {
        // Arrange
        val libraryUseCase = LibraryUseCase()
        val title = "Effective Kotlin"
        val author = "Marcin Moskala"
        libraryUseCase.addBook(title, author)

        // Act
        val books = libraryUseCase.listAllBooks()

        // Assert
        books.size shouldBe 1
        books[0].title shouldBe title
        books[0].author shouldBe author
    }
})