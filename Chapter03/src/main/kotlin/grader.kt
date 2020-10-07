class Grader {

    var studentGrades = mutableMapOf<String, Int>()
    var assignmentClasses = mutableMapOf<Int, Assignment>()

    fun register(assignment: Assignment) {

        val id = 1
        assignmentClasses[id] = assignment
    }
}