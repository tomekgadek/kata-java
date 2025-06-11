package pl.unittest.fourteenth_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MassReader {

    List<MassPoint> loadFromInputStream() {

        Scanner scanner = new Scanner(System.in);
        int numberOfPoints = scanner.nextInt();

        List<MassPoint> points = new ArrayList<>();
        for (int i = 0; i < numberOfPoints; i++) {
            MassPoint point =
                    new MassPoint(Double.parseDouble(scanner.next()),
                            Double.parseDouble(scanner.next()),
                            Double.parseDouble(scanner.next())
                    );

            points.add(point);
        }

        scanner.close();

        return points;
    }
}
