/*
 * Laboratorium 04:
 * 
 * Zaimplementuj program w jezyku Java, ktory zaprezentuje dzialanie macierzy rzadkiej.
 * Wykorzystaj wlasnosci macierzy rzadkiej. Nalezy uzyc tyle pamieci, ile jest 
 * niezbedne, nie marnuj zasobow.
 * 
 * Macierz rzadka to macierz, w ktorej większosc elementow to zera. Macierze 
 * tego typu występują w wielu problemach obliczeniowych, zwlaszcza w duzych 
 * systemach, gdzie przechowywanie wszystkich wartosci byloby nieefektywne. 
 * Zamiast tego, przechowuje się tylko niezerowe elementy, co pozwala na oszczędnosc 
 * pamieci i poprawe wydajnosci obliczen.
 * 
 * Cechy macierzy rzadkiej:
 * 
 * - Wiekszosc elementow to zera: tylko mała czesc elementow jest niezerowa.
 * - Efektywne przechowywanie: macierze rzadkie czesto są przechowywane w specjalnych 
 *   formatach, ktore zapisuja tylko niezerowe wartosci oraz ich pozycje.
 * 
 * Przyklad macierzy rzadkiej:
 * 
 * | 0, 6, 0 |
 * | 0, 0, 0 |
 * | 0, 8, 6 |
 * 
 * Zablokuj mozliwosc wprowadzania wiecej niz 50% wartosci niezerowych.
 */

import java.util.List;
import java.util.ArrayList;

record Value(int x, int y, int value) {}

class SparseMatrix {

    private final int size;
    private final List<Value> matrix;

    SparseMatrix(int size) {
        this.size = size;
        this.matrix = new ArrayList<>();
    }

    private void validateIndex(int x, int y) {
        if (x < 1 || y < 1 || x > size || y > size) {
            throw new IndexOutOfBoundsException("Invalid matrix index.");
        }
    }

    boolean set(int x, int y, int value) {

        validateIndex(x, y);

        if(matrix.size() >= ((size * size) / 2) && value != 0) { // (1)
            return false;
        }

        var element = matrix.stream().filter(v -> v.x() == x && v.y() == y).findFirst();
        
        if(element.isEmpty() && value != 0) { // (2)
    
            matrix.add(new Value(x, y, value));
        } else if(element.isPresent() && value == 0) { // (3)

            matrix.remove(element.get());
        } else if(element.isPresent() && value != 0) { // (4)

            int idx = matrix.indexOf(element.get());
            matrix.set(idx, new Value(x, y, value));
        }

        return true;
    }

    int get(int x, int y) {

        validateIndex(x, y);

        return matrix.stream()
            .filter(v -> v.x() == x && v.y() == y)
            .findFirst()
            .map(el -> el.value())
            .orElse(0);
    }
}

class Main {

    private final static int SIZE = 3;

    public static void main(String[] args) {

		var matrix = new SparseMatrix(SIZE);

		matrix.set( 1, 1, 5 ); // Nowa wartosc: warunek (2)
		matrix.set( 1, 2, 1 ); // Nowa wartosc: warunek (2)
		matrix.set( 3, 3, 6 ); // Nowa wartosc: warunek (2)
		matrix.set( 1, 2, 6 ); // Aktualizacja: warunek (4)
		matrix.set( 3, 2, 8 ); // Nowa wartosc: warunek (2)
		matrix.set( 3, 1, 9 ); // Za duza liczba wartosci niezerowych > 50%: warunek (1)
		matrix.set( 1, 1, 0 ); // Usuniecie elementu (przypisujemy value = 0): warunek (3)
		matrix.set( 1, 3, 0 ); // Staramy sie przypisac wartosc 0 elementowi, ktory w macierzy nie istnieje

        System.out.println("Macierz rzadka: \n");

        for(int i = 1; i <= SIZE; i++) {

            for(int j = 1; j <= SIZE; j++) {
                System.out.printf("%-3d ", matrix.get(i, j));
            }

            System.out.println();
        }

        System.out.println();
    }
}
