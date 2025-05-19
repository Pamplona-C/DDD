package ObjectCallistenic

// Principio da Responsabilidade Única

/*
Aqui foi um exemplo da aplicação do princípio da responsabilidade única.
Foi criado uma classe Customer e para tratar o uso da obsessão por tipos primitivos, por exemplo usar tipos primitivos para representar email, cpf ...
Foi criado uma classe Email para representar o email, e a classe Customer e Employee tem a responsabilidade de representar um cliente e um funcionário respectivamente.

 */

fun main() {
    println("Hello World!")

    var email = Email("Gustavogmail.com")

    var employee = Employee(email)

    println(employee.getEmail())

}
