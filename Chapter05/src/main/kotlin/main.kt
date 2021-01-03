fun main() {

    val doc = Document(fileName = "test_document")

    doc.insert("h")
    doc.insert("e")
    doc.insert("l")
    doc.insert("l")
    doc.insert("o")

    println(doc.characters.joinToString(""))

    doc.back()
    doc.delete()
    doc.insert("p")

    println(doc.characters.joinToString(""))

}
