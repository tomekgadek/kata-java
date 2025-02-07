package pl.unittest.second_lab;

/*
    Laboratorium 02:

    Napisz program w jezyku Java, ktory:

    - Oblicza odleglosc pomiedzy dwoma punktami na plaszczyznie 2D, na podstawie
      wspolrzednych podanych przez uzytkownika.
    - Sprawdza, czy na podstawie trzech punktow mozna skonstruowac trojkat, jesli
      TAK, oblicza jego obwod. W przeciwnym wypadku program powinien poinformowac
      uzytkownika, ze trojkat nie moze zostac skonstruowany.

      Przykladowy rezultat dzialania programu:

      Odleglosc p1-p2: 3,605551
      Obwod trojkata p1-p2-p3: 11,672571
 */

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
