import java.lang.NullPointerException
import javax.management.openmbean.KeyAlreadyExistsException

class Authenticator {
    var users: HashMap<String, User> = hashMapOf()

    fun addUser(username: String, password: String) {
        if(username in users.keys) {
            throw UserNameAlreadyExists(username)
        }

        if (password.length < 6) {
            throw PasswordTooShort(username)
        }

        users[username] = User(username, password)
    }

    fun login(username: String, password: String): Boolean {
        val user = try {
            users[username]!!
        }
        catch (e: NullPointerException) {
            throw InvalidUsername(username)
        }

        if(!user.checkPassword(password)) {
            throw InvalidPassword(username, user)
        }

        user.isLoggedIn = true
        return true
    }

    fun isLoggedIn(username: String?): Boolean {
        if(username in users.keys) {
            return users[username]!!.isLoggedIn
        }
        return false
    }
}