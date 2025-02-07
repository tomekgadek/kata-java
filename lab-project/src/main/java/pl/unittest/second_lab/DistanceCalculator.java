package pl.unittest.second_lab;

class DistanceCalculator {

    double calculate(Point2D p1, Point2D p2) {
        double deltaX = p2.x() - p1.x();
        double deltaY = p2.y() - p1.y();

        return  Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}
