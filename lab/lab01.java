/**
 * Laboratorium 01:
 * 
 * Napisz program, ktory oblicza logarytm naturalny z silni kolejnych
 * liczb calkowitych od 1 do 20. Wyswietl wynik wraz z wartoscia logarytmu
 * naturalnego silni.
 * 
 * Przykladowy rezultat dzialania programu:
 * 
 * 1    0.0
 * 2    0,693147
 * ...
 */

import java.lang.Math;

class Factorial {

    long calculate(final long digit) {

        if(digit == 0) {
            return 1;
        }

        return calculate(digit - 1) * digit;
    }
}

class Main {

    private static long LIMIT = 20;

    public static void main(String[] args) {

        var factorial = new Factorial();
        
        for(int digit = 1; digit <= LIMIT; digit++) {

            System.out.printf("%d\t%f \n", 
                digit, Math.log(factorial.calculate(digit))
            );
        }
    }
}
