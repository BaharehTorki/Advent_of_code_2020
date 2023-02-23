package se.nackademin


fun main() {
    println(FirstDay("").calcTwoNr(listOf()))
    println(FirstDay("").calcThreeNr(0, listOf()))
    println(FirstDay("").calc())
    println("1th part " + SecondDay("").countCorrectPasswordWithFirstPart())
    println("2th part " + SecondDay("").countCorrectPasswordWithSecondPart())

    println(SecondDay("").countCharInString("", '.'))
    //println(SecondDay("").countCorrectPasswordWithFirstPart())
    println(ThirdDay("").calculateTrees())

}

