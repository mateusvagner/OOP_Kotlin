fun main() {
   val authenticator = Authenticator()
   val authorizor = Authorizor(authenticator)

   authenticator.addUser("joe", "joepassword")
   authorizor.addPermission("test program")
   authorizor.addPermission("change program")
   authorizor.permitUser("test program", "joe")

   Editor(authenticator, authorizor).menu()
}