package ObjectCallistenic

class Customer {

    private var email : Email

    constructor(email: Email) {

        this.email = email
    }

    fun getEmail(): String {
        return email.getEmail()
    }
}

