package pl.unittest.ninth_lab;

import java.util.*;

/*
    Zadanie polega na napisaniu programu, który utworzy kolekcje 10 obiektów typu (klasy) Balloon.
    Baloniki maja różnic sie od siebie wielkościa. Wielkość balonika ma zostać wygenerowana losowo.
    Kolekcja ma zostać posortowana za pomocą stosownej implementacji interfejsu Comparator i wyświetlona od
    najmniejszego do najwiekszego balonika.
 */

public record Balloon(String name, double size) {
    public Balloon() {
        this("", 0.0);
    }
}

class BalloonSizeComparator implements Comparator<Balloon> {
    public int compare(Balloon b1, Balloon b2) {
        return Double.compare(b1.size(), b2.size());
    }
}
