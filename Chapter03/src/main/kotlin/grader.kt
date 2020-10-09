class Grader {

    var studentGrades = mutableMapOf<String, AssignmentGrader>()
    var assignmentClasses = mutableMapOf<Int, (String) -> Assignment>()

    fun register(assignment: (String) -> Assignment) {

        val id = 1
        assignmentClasses[id] = assignment
    }

    fun startAssignment(student: String, id: Int) {
        studentGrades[student] = AssignmentGrader(student, assignmentClasses[id]!!)

    }

    fun getLesson(student: String) {

    }
}