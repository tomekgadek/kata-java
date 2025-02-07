package pl.unittest.first_lab;

/*
    Laboratorium 01:

    Napisz program, ktory oblicza logarytm naturalny z silni kolejnych
    liczb calkowitych od 1 do 20. Wyswietl wynik wraz z wartoscia logarytmu
    naturalnego silni.

    Przykladowy rezultat dzialania programu:

    1    0.0
    2    0,693147
    ...
 */

class Factorial {

    private long calculate(final long digit) {

        if(digit == 0) {
            return 1;
        }

        return calculate(digit - 1) * digit;
    }

    double calculateLnFactorial(final long digit) {
        return Math.log(calculate(digit));
    }
}
