class Authorizor(private val authenticator: Authenticator) {

    var permissions: HashMap<String, MutableSet<String>> = hashMapOf()

    fun addPermission(permName: String) {
        try {
            permissions[permName]!!
            throw PermissionError("Permission Exists")
        }
        catch (e: NullPointerException) {
            permissions[permName] = mutableSetOf()
        }

//        permissions.getOrDefault(permName, mutableSetOf())
    }

    fun permitUser(permName: String, username: String) {
        try {
            val permSet = permissions[permName]!!
            if(username !in authenticator.users.keys) {
                throw InvalidUsername(username)
            }
            permSet.add(username) // TODO -> vai pro set do permissions[permName] por ser o mesmo objeto?
        }
        catch (e: NullPointerException) {
            throw PermissionError("Permission Does Not Exist.")
        }
    }

    fun checkPermission(permName: String, username: String?): Boolean {
        if(!(authenticator.isLoggedIn(username))) {
            throw NotLoggedInError(username)
        }

        try {
            val permSet = permissions[permName]!!
            if (username !in permSet) {
                throw NotPermittedError(username!!)
            } else {
                println("User have Permission")
                return true
            }
        }
        catch (e: NullPointerException) {
            throw PermissionError("Permission Does Not Exist")
        }
    }

}