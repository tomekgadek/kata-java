package pl.unittest.fourteenth_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MaterialPointModel {

    private final List<MaterialPoint> points;

    private MaterialPointModel() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPoints = scanner.nextInt();

        this.points = new ArrayList<>();
        for (int i = 0; i < numberOfPoints; i++) {
            MaterialPoint point =
                    new MaterialPoint(Double.parseDouble(scanner.next()),
                            Double.parseDouble(scanner.next()),
                            Double.parseDouble(scanner.next())
                    );

            if(point.mass() != 0.0) {
                this.points.add(point);
            }
        }

        scanner.close();
    }

    public static MaterialPointModel loadPointsFromInputStream() {
        return new MaterialPointModel();
    }

    public List<MaterialPoint> points() {
        return this.points;
    }
}
