package pl.unittest.sixth;

import java.util.Random;

/*
    Zadanie polega na zaimplementowaniu inteligentnej gry w zgadywanie liczb, bazując na dostarczonym
    interfejsie abstrakcyjnym. Twoim celem jest stworzenie konkretnej klasy, która będzie realizować
    funkcjonalność zgadywanki, gdzie komputer (a nie użytkownik) próbuje odgadnąć wylosowaną liczbę
    w jak najmniejszej liczbie kroków. Należy w tym celu zastosować odpowiedni algorytm wyszukiwania
    (wyszukiwanie binarne).
*/
abstract class GuessingGame {
    /** Zwraca najmniejszą możliwą liczbę do wylosowania. */
    abstract int getMin();

    /** Zwraca największą możliwą liczbę do wylosowania. */
    abstract int getMax();

    /** Inicjuje proces losowania nowej, ukrytej liczby. */
    abstract void generateNumber();

    /**
     * Podaje propozycję liczby do sprawdzenia. Implementacja powinna generować
     * propozycje zgodnie z wybranym algorytmem minimalizującym liczbę prób.
     */
    abstract int makeGuess();

    /** Sprawdza, czy podana propozycja jest zgodna z wylosowaną liczbą. */
    abstract boolean checkGuess(int guess);

    /** Sprawdza, czy podana propozycja jest większa niż wylosowana liczba. */
    abstract boolean checkIfGreater(int guess);

    /** Sprawdza, czy podana propozycja jest mniejsza niż wylosowana liczba. */
    abstract boolean checkIfSmaller(int guess);

    /** Potwierdza, czy rozwiązanie zostało znalezione. */
    abstract boolean isSolved();

    /** Zwraca liczbę przeprowadzonych testów (wywołań metod check*()) od
     * ostatniego wywołania generateNumber().
     */
    abstract int getNumberOfAttempts();
}

class GuessingGameImpl extends GuessingGame {
    private int min;
    private int max;
    private int hiddenValue;
    private int attemptCounter;
    private boolean found;

    public GuessingGameImpl() {
        this.min = 1;
        this.max = 100;
        this.hiddenValue = min;
        this.attemptCounter = 0;
        this.found = false;
    }

    public GuessingGameImpl(int min, int max, int value) {
        this();
        this.min = min;
        this.max = max;
        this.hiddenValue = value;
    }

    @Override
    public int getMin() {
        return this.min;
    }

    @Override
    public int getMax() {
        return this.max;
    }

    @Override
    public void generateNumber() {
        Random rand = new Random();
        hiddenValue = rand.nextInt(this.max - this.min + 1) + this.min;
        attemptCounter = 0;
        found = false;
    }

    @Override
    public int makeGuess() {
        throw new UnsupportedOperationException("This implementation does not guess numbers.");
    }

    @Override
    public boolean checkGuess(int guess) {
        attemptCounter++;
        if (guess == hiddenValue) {
            found = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIfGreater(int guess) {
        attemptCounter++;
        return guess > hiddenValue;
    }

    @Override
    public boolean checkIfSmaller(int guess) {
        attemptCounter++;
        return guess < hiddenValue;
    }

    @Override
    public boolean isSolved() {
        return found;
    }

    @Override
    public int getNumberOfAttempts() {
        return attemptCounter;
    }
}

abstract class AbstractSearch {
    public abstract void search(GuessingGame game);
}

class Search extends AbstractSearch {
    @Override
    public void search(GuessingGame game) {
        int min = game.getMin();
        int max = game.getMax();
        int guess = (min + max) / 2;

        if(game.checkIfSmaller(max)) return;
        if(game.checkIfGreater(min)) return;

        while (!game.checkGuess(guess)) {
            if (game.checkIfGreater(guess)) {
                max = guess - 1;
            } else if (game.checkIfSmaller(guess)) {
                min = guess + 1;
            }

            guess = (min + max) / 2;
        }
    }
}
