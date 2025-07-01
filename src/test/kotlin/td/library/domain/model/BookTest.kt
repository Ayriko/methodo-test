package td.library.domain.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import td.library.domain.usecase.LibraryUseCase

class BookTest: FunSpec({
    test("AddBook should throw IllegalArgumentException for blank title or author") {
        // Arrange
        val libraryUseCase = LibraryUseCase()

        // Act & Assert
        val exception1 = kotlin.runCatching { libraryUseCase.addBook("", "Author") }
        exception1.exceptionOrNull() shouldBe IllegalArgumentException("Title cannot be blank")

        val exception2 = kotlin.runCatching { libraryUseCase.addBook("Title", "") }
        exception2.exceptionOrNull() shouldBe IllegalArgumentException("Author cannot be blank")
    }
})