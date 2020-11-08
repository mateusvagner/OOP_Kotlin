import sun.security.util.Password
import java.security.MessageDigest

class User(var userName: String, password: String) {

    var isLoggedIn = false
    var encryptedPassword = encryptPassword(password)


    private fun encryptPassword(password: String): String {
        // https://gist.github.com/lovubuntu/164b6b9021f5ba54cefc67f60f7a1a25
        val userPlusPassword = userName+password

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