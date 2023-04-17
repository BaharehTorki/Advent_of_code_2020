package se.nackademin

import java.io.File

fun main() {
    val passwords = File("src/main/resources/secondReport.txt")
        .readLines()

        //Att anropa den här funktionen för att omvandla varje input rad till 'PasswordWithPolicy'
        .map(PasswordWithPolicy::parse)
        //.map(PasswordWithPolicy::parseUsingRegex)

    //Visa listan med lösenord för att se till att inmatningen läses korrekt
    println(passwords.count { it.validatePartOne() })
    println(passwords.count { it.validatePartTwo() })
}

//Modifier 'Data' för lagring av lösenordspolicy
//dataklassen instruerar till compiler att generera ett gäng användbara metoder för denna klass som: constructor, equals, hasCode och toString
data class PasswordWithPolicy(
    val password: String,
    //typ IntRange för att lagra en integer range
    val range: IntRange,
    val letter: Char,
) {

    //-------------------------------------------Första sättet för att konvertera input-------------------------------------------------
    //Omvandla en input rad i PasswordWithPolicy, eftersom det är funktionen som skapar en instans
    companion object {
        //parse funktion returnerar 'PasswordWithPolicy'
        fun parse(line: String) = PasswordWithPolicy(

            //password including String before colon
            password = line.substringAfter(": "),

            //'singleOrNull' returnerar null om input är tom eller innehåller fler tecken.
            letter = line.substringAfter(" ").substringBefore(":").single(),

            //Range går före blanktecken och består av två tal delade med bindestreck
            range = line.substringBefore(" ").let

            //Används 'destructuring declaration' syntax för att tilldela range till två variabler
            {
                val (start, end) = it.split("-")
                start.toInt()..end.toInt()
            },
        )

        //------------------------------------------Andra sättet för att konvertera input----------------------------------------------
        //Ett uttryck som beskriver delade siffror med bindestrecket, en bokstav och en grupp tecken för att definiera ett regelrätt uttryck
        private val regex = Regex("""(\d+)-(\d+) ([a-z]): ([a-z]+)""")

        //parseUsingRegex funktion som ska matcha raden mot ett regelrätt uttryck och sedan bygger 'PasswordWithPolicy'på resultatet
        fun parseUsingRegex(line: String): PasswordWithPolicy =

            //Att matcha den givna input mot regex pattern. Om försöket misslyckas, returneras "null"
            regex.matchEntire(line)!!

                //Returneras dessa komponenter redo för destructuring assignment
                .destructured

                //Att använda dess resultat i en lambda uttryck och parametrar som anpassar grupper i uttrycket och sedan bygger vi passwordWithPolicy-objektet.
                .let { (start, end, letter, password) ->

                    //Konvertera "start" och "end" sträng och extrahera "Char"
                    PasswordWithPolicy(password, start.toInt()..end.toInt(), letter.single())
                }
    }

    //Räknas upprepningar av 'bokstav' {it} och kontrollerar att resultatet är inom range
    fun validatePartOne() =
        password.count { it == letter } in range

    //Subtraheras 1 från 'range.first' eftersom policyn börjas indexera vid ett, men strängindexering börjar på noll
    fun validatePartTwo() =
        (password[range.first - 1] == letter) xor (password[range.last - 1] == letter)
}
