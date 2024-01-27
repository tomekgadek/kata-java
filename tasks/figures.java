/** Polimorfizm na przykładzie figur geometrycznych. */

import java.lang.Math;

abstract class Figure {

    abstract double area();
}

class Square extends Figure {

    private double side;

    Square(final double side) {
        this.side = side;
    }

    double area() {
        return Math.pow(this.side, 2.0);
    }
}

class Circle extends Figure {

    private double radius;

    Circle(final double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * Math.pow(this.radius, 2.0);
    }
}

class Main {

    public static void main(String[] args) {

        double a = 4.0;
        double r = 2.0;

        Figure square = new Square(a);
        Figure circle = new Circle(r);

        System.out.printf("Square (a = %.2f) area = %.2f \n", a, square.area());
        System.out.printf("Circle (r = %.2f) area = %.2f \n", r, circle.area());
    }
}