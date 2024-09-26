/*
 * Laboratorium 03:
 * 
 * Zaimplementuj program w jezyku Java, ktory zaprezentuje dzialanie macierzy symetrycznej.
 * Wykorzystaj wlasnosci macierzy symetrycznej i zoptymalizuj tworzenie tablicy dwuwymiarowej.
 * Nalezy uzyc tyle pamieci, ile jest niezbedne - nie marnuj zasobow.
 * 
 * Co to jest macierz symetryczna?
 * 
 * Macierz symetryczna to macierz kwadratowa, ktorej wyrazy polozone sa symetrycznie
 * wzgledem przekatnej glownej.
 * 
 * Macierz spelnia warunek: A(i, j) = A(j, i)
 * 
 * Przyklad macierzy symetrycznej:
 * 
 * |2, 1, 3|
 * |1, 6, 7|
 * |3, 7, 9|
 *
 */

class SymmetricMatrix {

    private int[][] matrix;

    SymmetricMatrix(final int size) {

        matrix = new int[size][];

        for(int i = 0; i < size; i++) {
            matrix[i] = new int[i + 1];
        }
    }

    private void validateIndex(int row, int col) {
        if (row < 1 || col < 1 || row > matrix.length || col > matrix.length) {
            throw new IndexOutOfBoundsException("Invalid matrix index.");
        }
    }

    /* metoda pozwala wpisac wartosc na pozycje row, col macierzy */
    void set(int row, int col, int value) {

        validateIndex(row, col);

        if(row >= col) {
            matrix[row - 1][col - 1] = value;
        } else {
            matrix[col - 1][row - 1] = value;
        }
    }

    /* metoda pozwala odczytac wartosc z pozycji row, col macierzy */
    int get(int row, int col) {

        validateIndex(row, col);

        if(row >= col) {
            return matrix[row - 1][col - 1];
        }

        return matrix[col - 1][row - 1];
    }

}

class Main {

    private static int SIZE = 3;

    public static void main(String[] args) {
        
        var matrix = new SymmetricMatrix(SIZE);

        matrix.set(1, 1, 2);
        matrix.set(2, 2, 6);
        matrix.set(3, 3, 9);
        matrix.set(3, 1, 3);
        matrix.set(2, 3, 7);
        matrix.set(1, 2, 1);

        System.out.println("Macierz symetryczna: \n");

        for(int i = 1; i <= SIZE; i++) {

            for(int j = 1; j <= SIZE; j++) {
                System.out.printf("%-3d ", matrix.get(i, j));
            }

            System.out.println();
        }

        System.out.println();
    }
}
