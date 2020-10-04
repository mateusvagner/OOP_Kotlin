class Notebook {
    /*
     * Represent a collection of notes that can be tagged, modified and searched.
     */

    // Initialize a notebook with and empty list.
    var notes = mutableListOf<Note>()

    fun newNote(id: Int, memo: String, tags: String = "") {
        // Create a new note and add it to the list.
        notes.add(Note(id, memo, tags))
    }

    fun modifyMemo(noteId: Int, memo: String) {
        // Find the note with the given Id and change its memo to the given value.
        notes.firstOrNull { it.id == noteId }?.memo = memo
    }

    fun modifyTags(noteId: Int, tags: String) {
        // Find the note with the given Id and change its tags to the given value.
        notes.firstOrNull { it.id == noteId }?.tags = tags
    }

    fun search(searchingWord: String): List<Note> {
        // Find all notes that match given filter string.
        return notes.filter { it.match(searchingWord) }
    }
}
