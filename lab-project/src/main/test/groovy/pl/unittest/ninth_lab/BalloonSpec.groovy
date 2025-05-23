package pl.unittest.ninth_lab

import spock.lang.Specification

class BalloonSpec extends Specification {

    def "should create balloon with name and size"() {
        when:
        def balloon = new Balloon("Test", 1.5)

        then:
        balloon.name() == "Test"
        balloon.size() == 1.5
    }

    def "should create empty balloon"() {
        when:
        def balloon = new Balloon()

        then:
        balloon.name() == ""
        balloon.size() == 0.0
    }

    def "should compare balloons by size"() {
        given:
        def comparator = new BalloonSizeComparator()
        def balloon1 = new Balloon("B1", 1.0)
        def balloon2 = new Balloon("B2", 2.0)
        def balloon3 = new Balloon("B3", 1.0)

        expect:
        comparator.compare(balloon1, balloon2) < 0
        comparator.compare(balloon2, balloon1) > 0
        comparator.compare(balloon1, balloon3) == 0
    }

    def "should compare five balloons and verify sizes using flattened lists"() {
        given:
        def balloons = [
                new Balloon("B1", 1.0),
                new Balloon("B2", 3.0),
                new Balloon("B3", 2.0),
                new Balloon("B4", 5.0),
                new Balloon("B5", 4.0)
        ]

        when:
        def sortedBalloons = new TreeSet<>(new BalloonSizeComparator())
        sortedBalloons.addAll(balloons)

        then:
        def sortedSizes = sortedBalloons.collect {it.size()}
        sortedSizes == [1.0, 2.0, 3.0, 4.0, 5.0]
    }
}
