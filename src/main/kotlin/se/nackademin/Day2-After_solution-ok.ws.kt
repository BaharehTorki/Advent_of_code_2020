package se.nackademin

import java.io.File

fun main() {
    val passwords = File("src/main/resources/secondReport.txt")
        .readLines()

        //Att anropa den här funktionen för att omvandla varje input rad till 'PasswordWithPolicy'
        .map(PasswordWithPolicy::parse)

    //Visa listan med lösenord för att se till att inmatningen läses korrekt
    println(passwords.count { it.validatePartOne() })
    println(passwords.count { it.validatePartTwo() })
}

//Modifier 'Data' för lagring av lösenordspolicy
//Dataklassen instruerar kompilatorn att generera ett gäng användbara metoder för denna klass som: constructor, equals, hasCode och toString
data class PasswordWithPolicy(
    val password: String,
    //typ IntRange för att lagra en integer range
    val range: IntRange,
    val letter: Char,
) {

    //We count the occurrences of 'letter' {it} in the password String, and check tha the result is in range
    fun validatePartOne() =

        //'in' checks that the given element belongs to a range
        //for numbers and other comparable elements, 'x in range' is the same as writing the following explicit check range.first <= x && x >= range.last
        password.count { it == letter } in range

    //WE subtract 1 from 'range.first' because the policy starts indexing at one, but String indexation starts at zero
    fun validatePartTwo() =
        (password[range.first - 1] == letter) xor (password[range.last - 1] == letter)


    //parses one input line into PasswordWithPolicy, since it is function that creates an instance
    //provide the parameter names explicitly
    companion object {
        //parse function return 'PasswordWithPolicy'
        fun parse(line: String) = PasswordWithPolicy(
            //password including String before colon
            password = line.substringAfter(": "),

            //If input is empty or contains more characters, 'singleOrNull' returns null.
            letter = line.substringAfter(" ").substringBefore(":").single(),

            //range goes before the whitespace and consists of two numbers split by the hyphen
            //First substring before the whitespace
            //call 'let' to introducing a new variable inside a lambda and later return the desired range as the result
            range = line.substringBefore(" ").let {

                //split the substring returned by the 'substringBefore' with hyphen
                //split returns a list of Strings as a result
                val (start, end) = it.split("-")

                //we use destructuring declaration syntax to assign the result into two variables
                start.toInt()..end.toInt()
            },
        )

        //We convert both lines to 'Int's and build a range using the 'rangeTo' operator

        //a regular expression describing the input format on the screen right now
        //First go two groups of numbers split with the hyphen, then a letter and then a group of characters by 'Regex' class for define a regular expression
        private val regex = Regex("""(\d+)-(\d+) ([a-z]): ([a-z]+)""")

        //parseUsingRegex that should match the line against a regular expression and then build 'PasswordWithPolicy´on the result
        fun parseUsingRegex(line: String): PasswordWithPolicy =

            //match entire function that tries to match the given input against the regex pattern.
            // If the attempt is unsuccessful and input doesn't correspond to the pattern, 'matchEntire' returns 'null'
            regex.matchEntire(line)!!

                    //destructured property returns these components ready for destructuring assignment
                .destructured

                //and then we use its result together with 'let' and destruct it inside the lambda expression
                //parameters corresponding to groups in a regular expression and
                // finally we build the passwordWithPolicy object.
                .let { (start, end, letter, password) ->

                    //Converting 'start' and 'end' String to Int and extract a single 'Char' from the 'letter' String
                    PasswordWithPolicy(password, start.toInt()..end.toInt(), letter.single())
                }
    }
}