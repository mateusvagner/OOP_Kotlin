import kotlin.system.exitProcess

class Menu {
    /*
     * Display a menu and respond to choices when run.
     */

    var notebook = Notebook()

    fun run() {
        while (true) {
            displayMenu()
            println("Enter an Option: ")
            when (readLine()!!) {
                "1" -> showNotes(notebook.notes)
                "2" -> searchNotes()
                "3" -> addNote()
                "4" -> modifyNote()
                "5" -> quit()
                else -> println("Non a valid option!!")
            }
        }
    }

    private fun displayMenu() {
        print(""" 
            Notebook Menu:
                1. Show all Notes
                2. Search Notes
                3. Add Note
                4. Modify Note
                5. Quit 
            """.trimIndent())
    }

    private fun showNotes(notes: List<Note>? = null) {
        if (notes.isNullOrEmpty()) {
            println("Empty List.")
        } else {
            notes.forEach {
                println("Note Id: ${it.id}")
                println("   Tags: ${it.tags}")
                println("   Memo: ${it.memo}")
                println("   Creation Date: ${it.creationDate}")
            }
        }
    }

    private fun searchNotes() {
        println("Search for: ")
        val filter =  readLine()!!
        val notes = notebook.search(filter)
        showNotes(notes)
    }

    private fun addNote() {
        println("Enter a memo: ")
        val memo =  readLine()!!
        println("Enter a tag: ")
        val tag =  readLine()!!

        notebook.newNote(10, memo, tag) // todo como fazer o esquema do id?
        println("Your note has been added.")
    }

    private fun modifyNote() {
        println("Enter Note Id to modify: ")
        val id = readLine()!!.toInt()

        val filteredNotesIsEmpty = notebook.notes.filter { it.id == id }.isNullOrEmpty()

        if (filteredNotesIsEmpty) {
            println("There is no Note with this Id")
        } else {
            performModification(id)
        }
    }

    private fun performModification(id: Int) {
        println("Enter a memo: ")
        val memo =  readLine()!!

        if (memo.isNotBlank()) {
            notebook.modifyMemo(id, memo)
        }

        println("Enter a tag: ")
        val tag =  readLine()!!

        if(tag.isNotBlank()) {
            notebook.modifyTags(id, tag)
        }
    }

    private fun quit() {
        println("Thanks for using notebook today")
        exitProcess(1)
    }
}
