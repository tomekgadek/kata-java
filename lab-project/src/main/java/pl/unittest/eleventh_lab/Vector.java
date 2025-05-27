package pl.unittest.eleventh_lab;

/*
    Napisz program, który:
    1. Losuje rozmiar tablicy (wektora) liczb typu double z zakresu od 5 do 10 (włącznie).
    2. Wypełnia tablicę losowymi wartościami typu double z przedziału [0.0, 1.0), wykorzystując do tego konstrukcję
       "try-catch", aby wykryć przekroczenie zakresu indeksów tablicy.
    3. Po zakończeniu wprowadzania danych, wyświetla wszystkie elementy tablicy, również z użyciem konstrukcji
       "try-catch", przerywając wyświetlanie, gdy przekroczony zostanie jej zakres.

    Wskazówka: Do obsługi losowania użyj klasy "java.util.Random", a do obsługi wyjątków użyj bloku "try-catch".
*/

import java.util.Random;

class Vector {

    public static int size() {

        java.util.Random random = new java.util.Random();

        // Generate a number between 5 and 10 inclusive
        return 5 + random.nextInt(6);
    }

    public static void fill(double[] vector) {

        final Random random = new Random();

        for (int index = 0; ; index++) {

            try {
                vector[index] = random.nextDouble();
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
                // Exception caught. Finished filling the vector.
            }
        }
    }

    public static void show(double[] vector) {

        for(int index = 0; ; index++) {

            try {
                System.out.printf("V[%d] = %.2f \n", index, vector[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                // Exception caught. Finished displaying the vector.
                break;
            }
        }
    }
}

class Main {

    public static void main(String[] args) {
        double[] vector = new double[Vector.size()];
        Vector.fill(vector);
        Vector.show(vector);
    }
}
