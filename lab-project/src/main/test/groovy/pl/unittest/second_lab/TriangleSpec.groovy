package pl.unittest.second_lab

import spock.lang.Specification

class TriangleSpec extends Specification {

    def "should calculate the perimeter of a valid triangle"() {
        given:
        def p1 = new Point2D(1.0, 2.0)
        def p2 = new Point2D(3.0, 5.0)
        def p3 = new Point2D(0.0, 0.0)
        def triangle = new Triangle()

        expect:
        triangle.perimeter(p1, p2, p3) > 0.0
    }

    def "should return 0.0 when the points do not form a valid triangle"() {
        given:
        def p1 = new Point2D(0.0, 0.0)
        def p2 = new Point2D(1.0, 1.0)
        def p3 = new Point2D(2.0, 2.0)
        def triangle = new Triangle()

        expect:
        triangle.perimeter(p1, p2, p3) == 0.0
    }
}
