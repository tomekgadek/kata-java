package pl.unittest.sixth;

/*
    Zadanie polega na zaimplementowaniu inteligentnej gry w zgadywanie liczb, bazując na dostarczonym
    interfejsie abstrakcyjnym. Twoim celem jest stworzenie konkretnej klasy, która będzie realizować
    funkcjonalność zgadywanki, gdzie komputer (a nie użytkownik) próbuje odgadnąć wylosowaną liczbę
    w jak najmniejszej liczbie kroków. Należy w tym celu zastosować odpowiedni algorytm wyszukiwania.
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
