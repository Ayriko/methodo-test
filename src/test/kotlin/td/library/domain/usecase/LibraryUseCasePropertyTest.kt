package td.library.domain.usecase

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LibraryUseCasePropertyTest: FunSpec ( {
    test("ListAllBooks should return books sorted by title") {
        // Arrange
        val libraryUseCase = LibraryUseCase()
        libraryUseCase.addBook("Zebra", "Author A")
        libraryUseCase.addBook("Apple", "Author B")
        libraryUseCase.addBook("Mango", "Author C")

        // Act
        val books = libraryUseCase.listAllBooks()

        // Assert
        books.map { it.title } shouldBe listOf("Apple", "Mango", "Zebra")
    }
})