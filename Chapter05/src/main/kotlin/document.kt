import java.io.File

class Document(
        private val fileName: String
) {

    var characters: MutableList<Character> = mutableListOf()
    var cursor: Cursor = Cursor(this)

    fun insert(character: Any) {
        when (character) {
            is Character -> {
                characters.add(cursor.position, character)
                cursor.forward()
            }
            is String -> {
                val characterObj = Character(character)
                characters.add(cursor.position, characterObj)
                cursor.forward()
            }
            else -> {
                throw TypeCastException()
            }
        }
    }

    fun delete() {
        characters.removeAt(cursor.position)
    }

    fun save() {
        File("$fileName.txt").printWriter().use { out ->
            out.println(characters.joinToString(""))
        }
    }

    fun forward() {
        cursor.forward()
    }

    fun back() {
        cursor.back()
    }

    fun string(): String {
        val text = this.characters.map { it.toString() }
        return text.joinToString("")
    }

}


