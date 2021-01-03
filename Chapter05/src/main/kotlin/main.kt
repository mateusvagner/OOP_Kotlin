fun main() {

    val doc = Document(fileName = "test_document")

    doc.insert("h")
    doc.insert("e")
    doc.insert("l")
    doc.insert("l")
    doc.insert("o")
    doc.insert("\n")
    doc.insert("w")
    doc.insert("o")
    doc.insert("r")
    doc.insert("l")
    doc.insert("d")

    doc.cursor.home()

    doc.insert("*")

    println(doc.characters.joinToString(""))

}
