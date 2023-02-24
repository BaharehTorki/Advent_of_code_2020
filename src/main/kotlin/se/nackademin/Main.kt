package se.nackademin

val firstDay = FirstDay("")
val secondDay = SecondDay("")
val thirdDay = ThirdDay("")
fun main() {

    println("Day1 part1:"+ firstDay.findTwoNumbersWith (2020))
    println("Day1 part2:" +firstDay.findThreeNumbersWith(2020))
    println("Day1 part2:" + firstDay.multipleList(firstDay.findThreeNumbersWith(2020)))

    println("Day2 part1:" + secondDay.countCorrectPasswordWithFirstPart())//439
    println("Day2 part2:" + secondDay.countCorrectPasswordWithSecondPart())//584

    println(secondDay.countCharInString("", '.'))
    println(secondDay.countCorrectPasswordWithFirstPart())

    println("Day3 part1: " + thirdDay.calculateTrees(3, 1))//216
    println("Day3 part2:" + thirdDay.calculateTrees2())//6708199680

}

