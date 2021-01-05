fun main() {

    val doc = Document("test_document")

    doc.insert("h")
    doc.insert("e")
    doc.insert(Character("l", bold = true))
    doc.insert(Character("l", bold = true))
    doc.insert("o")
    doc.insert("\n")
    doc.insert(Character("w", italic = true))
    doc.insert(Character("o", italic = true))
    doc.insert(Character("r", underline = true))
    doc.insert("l")
    doc.insert("d")

    println(doc.string())

    doc.cursor.home()
    doc.delete()
    doc.insert("W")

    println(doc.string())

    doc.characters[0].underline = true

    println(doc.string())

}
