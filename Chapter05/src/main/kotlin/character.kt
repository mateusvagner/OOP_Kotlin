class Character(
    val character: String,
    var bold: Boolean = false,
    var italic: Boolean = false,
    var underline: Boolean = false
) {

    val characterStr: String
        get() = getString()

    private fun getString(): String {
        val boldCharacter: String = if (bold) {
            "*"
        } else {
            ""
        }

        val italicCharacter: String = if (italic) {
            "/"
        } else {
            ""
        }

        val underlineCharacter: String = if (underline) {
            "_"
        } else {
            ""
        }
        return boldCharacter + italicCharacter + underlineCharacter + character
    }
}