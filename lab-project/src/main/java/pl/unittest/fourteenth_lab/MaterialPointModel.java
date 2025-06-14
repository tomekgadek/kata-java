package pl.unittest.fourteenth_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MaterialPointModel {

    private List<MaterialPoint> points = new ArrayList<>();

    List<MaterialPoint> loadFromInputStream() {

        Scanner scanner = new Scanner(System.in);
        int numberOfPoints = scanner.nextInt();

        points = new ArrayList<>();
        for (int i = 0; i < numberOfPoints; i++) {
            MaterialPoint point =
                    new MaterialPoint(Double.parseDouble(scanner.next()),
                            Double.parseDouble(scanner.next()),
                            Double.parseDouble(scanner.next())
                    );

            points.add(point);
        }

        scanner.close();

        return points;
    }

    public List<MaterialPoint> getPoints() {
        return this.points;
    }
}
