/** Polimorfizm a punkty w przestrzeni. */

class Point {
    protected int x;

    Point(final int x) {
        this.x = x;
    }

    public String toString() {
        return String.format("(%s)", this.x);
    }
}

class Point2D extends Point {
    protected int y;

    Point2D(final int x, final int y) {
        super(x);
        this.y = y;
    }

    public String toString() {
        return String.format("(%s, %s)", this.x, this.y);
    }
}

class Point3D extends Point2D {
    private int z;

    Point3D(final int x, final int y, final int z) {
        super(x, y);
        this.z = z;
    }

    public String toString() {
        return String.format("(%s, %s, %s)", this.x, this.y, this.z);
    }
}

class Main {

    public static void main(String[] args) {

        Point p1 = new Point(2);
        Point p2 = new Point2D(1, 4);
        Point p3 = new Point3D(3, 6, 9);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
