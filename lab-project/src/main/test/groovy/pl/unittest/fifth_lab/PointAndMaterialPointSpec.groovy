package pl.unittest.fifth_lab

import spock.lang.Specification
import spock.lang.Subject

class PointAndMaterialPointSpec extends Specification {

    @Subject
    def calculations = new Calculations()

    private static boolean almostEqual(double a, double b, double epsilon = 1e-6) {
        Math.abs(a - b) < epsilon
    }

    def "should calculate center of geometry for two points"() {
        given:
        def points = [
                new Point2D(0.0, 0.0),
                new Point2D(10.0, 10.0)
        ] as Point2D[]

        when:
        def result = Calculations.centerOfGeometry(points)

        then:
        almostEqual(result.x, 5.0)
        and:
        almostEqual(result.y, 5.0)
    }

    def "should calculate center of mass for two mass points"() {
        given:
        def points = [
                new MassPoint2D(0.0, 0.0, 1.0),
                new MassPoint2D(10.0, 10.0, 100.0)
        ] as MassPoint2D[]

        when:
        def result = Calculations.centerOfMass(points)

        then:
        almostEqual(result.x, 9.90099009900990)
        and:
        almostEqual(result.y, 9.90099009900990)
    }
}
