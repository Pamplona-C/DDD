package books

import books.controller.BookController
import books.domain.BookRequestDto

fun main()
{

    println("Gerenciador de Livros")
    println("Digite um livro : ")

    var nameLivro = readLine().orEmpty()

    println("Agora digite a categoria do livro : ")
    var categoryBook = readLine().orEmpty()

    val dto = BookRequestDto(nameLivro, categoryBook)

    var books = BookController()


    books.criarBook(dto)

    books.getAllBooks()
}
