package pl.unittest.eighth_lab;

/*
    Na podstawie interfejsu GameRules zaimplementuj dwie klasy: Hetman oraz Konik.
    Obie klasy powinny implementować interfejs GameRules i definiować metodę isValidMove
    zgodnie z zasadami poruszania się odpowiednio hetmana i konika (skoczka) w szachach.
 */

record Point(int x, int y) {}

interface GameRules {
    /** Metoda zwraca true, tylko gdy przejscie z polozenia source(x, y) do destination(x, y)
     w jednym ruchu jest zgodne z zasadami gry w szachy */
    boolean isValidMove(final Point source, final Point destination);
}
