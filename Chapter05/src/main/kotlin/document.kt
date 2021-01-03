import java.io.File

class Document(
    var characters: MutableList<String> = mutableListOf(),
    var cursor: Int = 0,
    val fileName: String
) {

    fun insert(character: String) {
        characters.add(cursor, character)
        cursor += 1
    }

    fun delete() {
        characters.removeAt(cursor)
    }

    fun save() {
        File("$fileName.txt").printWriter().use { out ->
            out.println(characters.joinToString(""))
        }
    }

    fun forward() {
        cursor += 11
    }

    fun back() {
        cursor -= 1
    }

}


