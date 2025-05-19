package ObjectCallistenic

class Employee {

    private var email: Email

    constructor(email: Email) {

        this.email = email
    }

    fun getEmail(): String {
        return email.getEmail()
    }
}
