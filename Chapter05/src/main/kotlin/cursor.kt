class Cursor(
    val document: Document,
    var position: Int = 0
) {

    fun forward() {
        position += 1
    }

    fun back() {
        position -= 1
    }

    fun home() {
        while (document.characters[position-1] != "\n") {
            position -= 1
            if (position == 0) break // Got to beginning of file
        }
    }

    fun end() {
        while (position < document.characters.size && document.characters[position] != "\n") {
            position += 1
        }
    }



}