package books.domain

class Book {

    private final val name : String
    private val category : String

    constructor(name : String, category: String){
        this.name = name
        this.category = category
    }

    fun getName(): String {
        return name
    }

    fun getCategory() : String {
        return category
    }

    override fun toString() : String{
        return "Nome : " + name +
                "\nCatgoria : " + category
    }


}
