/** Wyznaczanie silni. Wersja iteracyjna oraz rekurencyjna. */

class Factorial {
    
    long iter(long digit) {

        long result = 1;

        for(int i = 2; i <= digit; i++) {
            result *= i;
        }

        return result;
    }

    long rec(long digit) {
        if(digit <= 1) {
            return 1;
        }

        return digit * rec(digit - 1);
    }
}

class Main {

    public static void main(String[] args) {

        Factorial factorial = new Factorial();

        assert factorial.iter(0) == 1;
        assert factorial.iter(1) == 1;
        assert factorial.iter(2) == 2;
        assert factorial.iter(3) == 6;

        assert factorial.rec(0) == 1;
        assert factorial.rec(1) == 1;
        assert factorial.rec(2) == 2;
        assert factorial.rec(3) == 6;
    }
}

/*
    Kompilacja: javac factorial.java
    Uruchomienie z obsługą asercji: java -ea Main
*/