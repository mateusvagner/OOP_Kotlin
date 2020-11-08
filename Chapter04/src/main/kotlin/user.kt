import java.security.MessageDigest

class User(private var username: String, password: String) : Throwable() {

    var isLoggedIn = false
    var encryptedPassword = encryptPassword(password)


    private fun encryptPassword(password: String): String {
        // https://gist.github.com/lovubuntu/164b6b9021f5ba54cefc67f60f7a1a25
        val userPlusPassword = username+password

        val bytes = userPlusPassword.toByteArray()
        val digest = MessageDigest
            .getInstance("SHA-256")
            .digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }

    fun checkPassword(password: String): Boolean {
        return encryptPassword(password) == encryptedPassword
    }
}