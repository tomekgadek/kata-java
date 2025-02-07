package pl.unittest.second_lab

import spock.lang.Specification

class DistanceCalculatorSpec extends Specification {

    def "should calculate distance between two points"() {
        given:
        def p1 = new Point2D(1.0, 2.0)
        def p2 = new Point2D(3.0, 5.0)
        def calculator = new DistanceCalculator()

        expect:
        calculator.calculate(p1, p2) == Math.sqrt(13)
    }
}
