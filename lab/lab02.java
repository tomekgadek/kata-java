/**
 * Laboratorium 02:
 * 
 * Napisz program w jezyku Java, ktory:
 * 
 * - Oblicza odleglosc pomiedzy dwoma punktami na plaszczyznie 2D, na podstawie
 *   wspolrzednych podanych przez uzytkownika.
 * - Sprawdza, czy na podstawie trzech punktow mozna skonstruowac trojkat, jesli 
 *   TAK, oblicza jego obwod. W przeciwnym wypadku program powinien poinformowac 
 *   uzytkownika, ze trojkat nie moze zostac skonstruowany.
 * 
 * Przykladowy rezultat dzialania programu:
 * 
 * Odleglosc p1-p2: 3,605551 
 * Obwod trojkata p1-p2-p3: 11,672571
 * 
 */

import java.lang.Math;

record Point2D(double x, double y) {}

class DistanceCalculator {

    double calculate(Point2D p1, Point2D p2) {
        double deltaX = p2.x() - p1.x();
        double deltaY = p2.y() - p1.y();

        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        return distance;
    }
}

class Triangle {

    double perimeter(Point2D p1, Point2D p2, Point2D p3) {

        var distanceCalculator = new DistanceCalculator();

        double a = distanceCalculator.calculate(p1, p2);
        double b = distanceCalculator.calculate(p2, p3);
        double c = distanceCalculator.calculate(p3, p1);

        /* 
            Twierdzenie matematyczne:

            Suma dlugosci dwoch dowolnych bokow musi byc wieksza niz
            dlugosc trzeciego boku - tzw. 'nierownosc trojkata'.
        */
        if(a < b+c && b < a+c && c < b+a) {
            return a + b + c;
        }

        return 0.0;
    }
}

class Main {

    public static void main(String[] args) {

        var p1 = new Point2D(1.0, 2.0);
        var p2 = new Point2D(3.0, 5.0);
        var p3 = new Point2D(0.0, 0.0);

        System.out.printf("Odleglosc p1-p2: %f \n", 
            new DistanceCalculator().calculate(p1, p2));

        var triangle = new Triangle();

        if(triangle.perimeter(p1, p2, p3) != 0.0) {
            System.out.printf("Obwod trojkata p1-p2-p3: %f \n", 
                triangle.perimeter(p1, p2, p3));
        } else {
            System.out.println("Bledne dane. Trojkata nie da sie skonstruowac.");
        }
    }
}
