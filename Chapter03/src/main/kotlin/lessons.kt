
class IntroToKotlin(override var student: String) : Assignment {


    override fun lesson() {
        println(""" 
            Hello, ${student}. Define two variables,
            an integer named 'a' with value 1
             and a string named 'b' with value 'hello'.
        """.trimIndent())
    }

    override fun check(code: String): Boolean {
        return code == "a = 1\nb = 'hello'"
    }
}

class Statistics(override var student: String) : Assignment {

    override fun lesson() {
        println(""" 
            Good work so far, ${student}.
            Now calculate the average of 
            the numbers 1, 5, 18, -3 and
            assign to a variable named 'avg'.
        """.trimIndent())
    }

    override fun check(code: String): Boolean {
        return code == "5,25"
    }
}
