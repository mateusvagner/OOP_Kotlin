import java.util.*

class Grader {

    var studentGrades = mutableMapOf<String, AssignmentGrader>()
    var assignmentClasses = mutableMapOf<Int, (String) -> Assignment>()

    fun register(assignment: (String) -> Assignment) {

        val id = UUID.randomUUID().hashCode()
        assignmentClasses[id] = assignment
    }

    fun startAssignment(student: String, id: Int) {
        studentGrades[student] = AssignmentGrader(student, assignmentClasses[id]!!)

    }

    fun getLesson(student: String) {
        val assignment = studentGrades[student]
        assignment?.lesson()
    }

    fun checkAssignment(student: String, code: String): Boolean? {
        val assignment = studentGrades[student]
        return assignment?.check(code)
    }

    fun assignmentSummary(student: String) {
        val grader = studentGrades[student]
        println(""" 
            ${student}'s attempts att ${grader!!.assignment.javaClass.name}:
             - Attempts: ${grader.attempts}
             - Correct: ${grader.correctAttempts}
             - Passed: ${grader.correctAttempts > 0}
        """.trimIndent())
    }
}