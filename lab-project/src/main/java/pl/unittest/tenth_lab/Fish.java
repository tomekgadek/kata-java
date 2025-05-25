package pl.unittest.tenth_lab;

/*
    Zadanie polega na napisaniu programu, który wygeneruje kolekcję rybek akwariowych. Klasa Fish ma zawierać co
    najmniej takie informacje jak: Nazwa, nazwa łacińska, długość, temperatura minimalna wody, temperatura maksymalna
    wody.Proszę wprowadzić do programu informacje o kilku wybranych gatunkach i za pomocą odpowiedniej klasy
    implementującej interfejs Comparator rybki posortować w kolejności alfabetycznej wg. nazwy polskiej, alfabetycznej
    wg. nazwy łacińskiej, rosnącej długości, malejącej temperatury minimalnej i rosnącej temperatury maksymalnej.
    Oczywiście proszę o zaprezentowanie wyników tych sortowań. Warto zadbać o to aby gatunki wprowadzone do programu
    prowadziły do innej kolejności rybek po zmianie kategorii.
*/

import java.util.Comparator;

public class Fish {
    private final String name;
    private final String latinName;
    private final double length;
    private final double minWaterTemp;
    private final double maxWaterTemp;

    public Fish(String name, String latinName, double length, double minTemp, double maxTemp) {
        this.name = name;
        this.latinName = latinName;
        this.length = length;
        this.minWaterTemp = minTemp;
        this.maxWaterTemp = maxTemp;
    }

    public String getName() {
        return name;
    }

    public String getLatinName() {
        return latinName;
    }

    public double getLength() {
        return length;
    }

    public double getMinWaterTemp() {
        return minWaterTemp;
    }

    public double getMaxWaterTemp() {
        return maxWaterTemp;
    }

    public static Comparator<Fish> byName = (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName());

    public static Comparator<Fish> byLatinName = (f1, f2) -> f1.getLatinName().compareToIgnoreCase(f2.getLatinName());

    public static Comparator<Fish> byLength = Comparator.comparingDouble(Fish::getLength);

    public static Comparator<Fish> byMinTempDesc = (f1, f2) -> Double.compare(f2.getMinWaterTemp(), f1.getMinWaterTemp());

    public static Comparator<Fish> byMaxTemp = Comparator.comparingDouble(Fish::getMaxWaterTemp);

    @Override
    public String toString() {
        return name + " (lat. " + latinName + ") Length: " + length +
                " MIN_TEMP: " + minWaterTemp + " MAX_TEMP: " + maxWaterTemp;
    }
}
