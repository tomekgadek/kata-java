/** Jak działa metoda o zmiennej liczbie argumentów? */

class Point {

    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
}

class Figure {

    void recognize(String name, Point... points) {
        System.out.printf("It is %-8s. ", name);

        System.out.print("Points: ");
        for(Point point: points) {
            System.out.print(point);
        }

        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(2, 2);
        Point c = new Point(2, 0);
        Point d = new Point(0, 2);

        Point[] triangle = new Point[]{ a, c, d };
        Point[] square = new Point[]{ a, b, c, d };

        Figure figure = new Figure();

        figure.recognize("Triangle", triangle);
        figure.recognize("Square", square);
    }
}
