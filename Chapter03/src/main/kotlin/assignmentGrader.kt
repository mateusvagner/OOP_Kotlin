class AssignmentGrader( val student: String, lessonConstructor: (String) -> Assignment) {

    var attempts = 0
    var correctAttempts = 0
    var assignment = lessonConstructor(student)


    fun check(code: String): Boolean {
        this.attempts += 1
        val isResultCorrect = assignment.check(code)
        if (isResultCorrect) {
            correctAttempts =+ 1
        }
        return isResultCorrect
    }

    fun lesson() {
        assignment.lesson()
    }



}