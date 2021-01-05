class Cursor(
    private val document: Document,
    var position: Int = 0
) {

    fun forward() {
        position += 1
    }

    fun back() {
        position -= 1
    }

    fun home() {
        if (document.characters.isEmpty()) return

        while (document.characters[position-1].character != "\n") {
            if (position == 0) break // Got to beginning of file
            position -= 1
        }
    }

    fun end() {
        while (position < document.characters.size && document.characters[position].character != "\n") {
            position += 1
        }
    }



}