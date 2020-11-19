open class AuthException(username: String?, user: User? = null) : Exception(username, user)

class UserNameAlreadyExists(username: String) : AuthException(username)

class PasswordTooShort(username: String) : AuthException(username)

class InvalidUsername(username: String) : AuthException(username)

class InvalidPassword(username: String, user: User? = null) : AuthException(username, user)

class PermissionError(message: String) : Exception(message)

class NotLoggedInError(username: String?) : AuthException(username)

class NotPermittedError(username: String) : AuthException(username)