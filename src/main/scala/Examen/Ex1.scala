package Examen

import com.cra.figaro.language._
import com.cra.figaro.library.compound.{If, CPD, RichCPD, OneOf}
import com.cra.figaro.algorithm.factored.VariableElimination
import com.cra.figaro.algorithm.sampling._

object Ex1 {

    class Stare() {
        val months = 12
        val preturi: Array[Element[Symbol]] = Array.fill(months)(Constant('scad))
        val vanzari: Array[Element[Symbol]] = Array.fill(months)(Constant('mediu))
        preturi(0) = Select(0.2 -> 'cresc, 0.5 -> 'stagneaza, 0.3 -> 'scad)
        for { month <- 1 until months }
        {
            preturi(month) = CPD(preturi(month - 1),
                'cresc -> Select(0.1 -> 'cresc, 0.7 -> 'stagneaza, 0.2 -> 'scad),
                'stagneaza -> Select(0.33 -> 'cresc, 0.33 -> 'stagneaza, 0.33 -> 'scad),
                'scad -> Select(0.3 -> 'cresc, 0.6 -> 'stagneaza, 0.1 -> 'scad))
        }
        for { month <- 1 until months }
        {
            vanzari(month)=CPD(preturi(month),'cresc -> Select(0.1 -> 'ridicat, 0.2 -> 'mediu, 0.2 -> 'scazut, 0.5 -> 'ftscazut),
            'stagneaza -> Select(0.3 -> 'ridicat, 0.3 -> 'mediu, 0.2 -> 'scazut, 0.2 -> 'ftscazut),
            'scad -> Select(0.4 -> 'ridicat, 0.3 -> 'mediu, 0.2 -> 'scazut, 0.1 -> 'ftscazut))
        }
    }

    class StareInitiala(){
        val preturi = Select(0.2 -> 'cresc, 0.5 -> 'stagneaza, 0.3 -> 'scad)
        val vanzari = CPD(preturi,
            Constant('cresc) -> Select(0.1 -> 'ridicat, 0.2 -> 'mediu, 0.2 -> 'scazut, 0.5 -> 'ftscazut),
			Constant('stagneaza)-> Select(0.3 -> 'ridicat, 0.3 -> 'mediu, 0.2 -> 'scazut, 0.2 -> 'ftscazut),
			Constant('scad) -> Select(0.4 -> 'ridicat, 0.3 -> 'mediu, 0.2 -> 'scazut, 0.1 -> 'ftscazut))
    }

    // class StareUrmatoare(val st:StareInitiala){
        // val preturiCurent =

    def main(args: Array[String]) {
        
    }
}