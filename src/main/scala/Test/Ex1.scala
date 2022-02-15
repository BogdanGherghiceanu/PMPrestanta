package Test

import com.cra.figaro.language._
import com.cra.figaro.algorithm.factored
import com.cra.figaro.library.compound.If
import com.cra.figaro.algorithm.factored.VariableElimination
import com.cra.figaro.library.atomic.discrete.Binomial
object Ex1{
    def main(args: Array[String]){
    //    val greeting = Select(0.2 -> "Hello, world!", 0.6 -> "Howdy, universe!",
    //                         0.2 -> "Oh no, not again")
    //     println(VariableElimination.probability(greeting, "Howdy, universe!"))
    val numSunnyDaysInWeek = Binomial(2, 7)
    println(VariableElimination.probability(numSunnyDaysInWeek, 3))

    }
}