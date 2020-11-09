import java.lang.NullPointerException
import kotlin.system.exitProcess

class Editor(private val authenticator: Authenticator, private val authorizor: Authorizor) {
    var username: String? = null
    var menuMap: HashMap<String, String?> = hashMapOf(
            "login" to "login",
            "test" to "test",
            "change" to "change",
            "quit" to "quit")


    fun login(){
        var loggedIn = false
        while (!loggedIn) {
            println("username: ")
            val username = readLine()!!
            println("password: ")
            val password = readLine()!!

            try {
                loggedIn = this.authenticator.login(username, password)
                this.username = username
            }
            catch (e: InvalidUsername) {
                println("Sorry, that username does not exist")
            }
            catch (e: InvalidPassword) {
                println("Sorry, incorrect password")
            }
        }
    }

    fun isPermitted(permission: String): Boolean {
        return try {
            authorizor.checkPermission(permission, username!!)
            true
        }
        catch (e: NotLoggedInError) {
            println("$username is not logged in")
            false
        }
        catch (e: NotPermittedError) {
            println("$username can not $permission")
            false
        }
    }

    fun test() {
        if(isPermitted("test program")) {
            println("Testing program now")
        }
    }

    fun change() {
        if(isPermitted("change program")) {
            println("Changing program now")
        }
    }

    fun quit() {
        exitProcess(1 )
    }

    fun menu() {
        var answer: String = ""
        try {
            while (true) {
                println("""
                    
    Please enter a command:
        type:
            login for Login
            test for Test
            change for Change
            quit for Quit
            
                        """)
            answer = readLine()!!
                try {
                    when(menuMap[answer]!!) {
                        "login" -> this.login()
                        "test" -> this.test()
                        "change" -> this.change()
                        "quit"  -> this.quit()
                    }
                }
                catch (e: NullPointerException) {
                    println("$answer is not a valid option")
                }
            }
        }
        finally {
            println("Thank you for testing the auth module")
        }
    }
}