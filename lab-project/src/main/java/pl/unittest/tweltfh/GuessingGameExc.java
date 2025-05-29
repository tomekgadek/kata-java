package pl.unittest.tweltfh;

/*
    Zdefiniuj interfejs o nazwie "GuessingGameExc" z jedną metodą:

    void isItTheNumber(int guess), która

    może zgłaszać dwa wyjątki kontrolowane:
    a) TooHighException – jeśli podana liczba jest za duża,
    b) TooLowException – jeśli podana liczba jest za mała.

    Implementacja tego interfejsu powinna wewnętrznie przechowywać szukaną liczbę.

    Metoda isItTheNumber(int) porównuje podaną wartość z szukaną liczbą i w razie niezgodności rzuca odpowiedni wyjątek.
*/

interface GuessingGameExc {
    void isItTheNumber(int guess) throws GuessingGameExc.TooHighException, GuessingGameExc.TooLowException;

    class TooHighException extends Exception {}
    class TooLowException extends Exception {}
}

class Main {

    public static void main(String[] args) {
        System.out.println("OK");
    }
}
