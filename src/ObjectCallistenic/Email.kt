package ObjectCallistenic

class Email {

    private var value: String

    constructor(value: String) {
        validate(value)
        this.value = value
    }

    fun validate(email : String){
        if (!email.contains("@") || !email.contains(".")){
            throw Exception("Email inválido")
        }
    }

    fun getEmail(): String{
        return value
    }
}
