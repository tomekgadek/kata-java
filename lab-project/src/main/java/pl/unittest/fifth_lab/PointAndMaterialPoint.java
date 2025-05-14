package pl.unittest.fifth_lab;

/*
    Proszę napisać program, który:

    + Będzie posiadać klasę Point2D. Ma ona reprezentować punkt na płaszczyźnie. Klasa musi
      posiadać metodę toString() przeznaczoną do prezentacji położenia punktu oraz dwupamaretrowy
      konstruktor, który pozwoli na inicjację położenia punktu.
    + Będzie posiadać klasę MassPoint2D rozszerzającą klasę Point2D o pole: mass.
      (https://pl.wikipedia.org/wiki/Punkt_materialny). Klasa ta musi posiadać metodę toString()
      prezentującą położenie punktu i jego masę oraz trójparametrowy konstruktor, który pozwoli
      na inicjację położenia i masy punktu.
    + Będzie posiadać klasę Calculations, w której...

      - statyczna publiczna metoda "Point2D centerOfGeometry(Point2D[])" wyliczy położenie środka
        geometrycznego układu punktów, dostarczonych w postaci tablicy.

      - statyczna publiczna metoda "Point2D centerOfMass(MassPoint2D[])" wyliczy położenie środka
        masy układu punktów, dostarczonych w postaci tablicy.

    + Współrzędne i masa są liczbami zmiennoprzecinkowymi.
    + Proste wzory na wyliczenie środka masy i środka geometrycznego:
      https://pl.wikipedia.org/wiki/%C5%9Arodek_masy
    + Proszę nie powielać kodu.
*/

import java.util.Arrays;

class Point2D {
    protected double x, y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class MassPoint2D extends Point2D {
    private double mass;

    public MassPoint2D(double x, double y, double mass) {
        super(x, y);
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    public String toString() {
        return "(" + x + ", " + y + ", mass: " + mass + ")";
    }
}

class Calculations {
    public static Point2D centerOfGeometry(Point2D[] points) {
        double avgX = Arrays.stream(points).mapToDouble(Point2D::getX).average().orElse(0);
        double avgY = Arrays.stream(points).mapToDouble(Point2D::getY).average().orElse(0);
        return new Point2D(avgX, avgY);
    }

    public static Point2D centerOfMass(MassPoint2D[] points) {
        double totalMass = Arrays.stream(points).mapToDouble(MassPoint2D::getMass).sum();
        double weightedX = Arrays.stream(points).mapToDouble(p -> p.getX() * p.getMass()).sum();
        double weightedY = Arrays.stream(points).mapToDouble(p -> p.getY() * p.getMass()).sum();
        return new Point2D(weightedX / totalMass, weightedY / totalMass);
    }
}
