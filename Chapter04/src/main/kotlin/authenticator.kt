import javax.management.openmbean.KeyAlreadyExistsException

class Authenticator {

//    catch (e: KeyAlreadyExistsException)

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

    fun login(username: String, password: String) {
        val user = try {
            users[username]!!
        }
        catch (e: IllegalArgumentException) {
            throw InvalidUsername(username)
        }

        if(!user.checkPassword(password)) {
            throw InvalidPassword(username, user)
        }

        user.isLoggedIn = true
    }

    fun isLoggedIn(username: String): Boolean {
        if(username in users.keys) {
            return users[username]!!.isLoggedIn
        }
        return false
    }
}