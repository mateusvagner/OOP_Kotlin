fun main() {


    val grader = Grader()

    val introToKotlinId = grader.register { IntroToKotlin(it) }
    val statisticsId = grader.register { Statistics(it) }

    val mateus = "Mateus"

    grader.startAssignment(mateus, introToKotlinId)
    println("Mateus' lesson: ")
    grader.getLesson(mateus)
    println("Mateus' check: ${grader.checkAssignment(mateus, "a = 1 ; b = 'hello'")}")
    println("Mateus' other check: ${grader.checkAssignment(mateus, "a = 1\nb = 'hello'")}")
    grader.assignmentSummary(mateus)

    grader.startAssignment(mateus, statisticsId)
    println("Mateus' lesson: ")
    grader.getLesson(mateus)
    println("Mateus' check: ${grader.checkAssignment(mateus, "5,25")}")
    println("Mateus' other check: ${grader.checkAssignment(mateus, "6,75")}")
    grader.assignmentSummary(mateus)
}