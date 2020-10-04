import java.time.LocalDateTime

class Note(val id: Int,
           var memo: String,
           var tags: String = "",
           val creationDate: LocalDateTime? = LocalDateTime.now()) {
/*
 * Represent a note in the notebook. Match against a string in searches and store tags for each note.
 */

    fun match(filter: String): Boolean {
        return filter.contains(memo) || filter.contains(tags)
    }
}

