package pl.unittest.eighth_lab;

/*
    Na podstawie interfejsu GameRules zaimplementuj dwie klasy: Hetman oraz Konik.
    Obie klasy powinny implementować interfejs GameRules i definiować metodę isValidMove
    zgodnie z zasadami poruszania się odpowiednio hetmana (Queen) i konika (Knight) w szachach.
 */

interface GameRules {
    record Point(int x, int y) {
    }

    /**
     * Metoda zwraca true, tylko gdy przejscie z polozenia source(x, y) do destination(x, y)
     * w jednym ruchu jest zgodne z zasadami gry w szachy
     */
    boolean isValidMove(final Point source, final Point destination);

    class Knight implements GameRules {
        @Override
        public boolean isValidMove(final Point source, final Point destination) {
            int deltaX = Math.abs(destination.x() - source.x());
            int deltaY = Math.abs(destination.y() - source.y());

            System.out.println("Knight deltaX = " + deltaX + ", deltaY = " + deltaY);

            return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
        }
    }

    class Queen implements GameRules {
        @Override
        public boolean isValidMove(final Point source, final Point destination) {
            if (source.x() == destination.x() || source.y() == destination.y()) {
                return true;
            }

            return Math.abs(destination.x() - source.x()) == Math.abs(destination.y() - source.y());
        }

    }
}
