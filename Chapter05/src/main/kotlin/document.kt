import java.io.File

class Document(
    var characters: MutableList<String> = mutableListOf(),
    val fileName: String
) {

    var cursor: Cursor = Cursor(this)

    fun insert(character: String) {
        characters.add(cursor.position, character)
        cursor.forward()
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

}


