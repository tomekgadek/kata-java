package pl.unittest.tenth_lab

import spock.lang.Specification

class FishSpec extends Specification {
    List<Fish> fishes

    def setup() {
        fishes = [
                new Fish("Gupik", "Poecilia reticulata", 3.5, 22.0, 28.0),
                new Fish("Neon Innesa", "Paracheirodon innesi", 4.0, 20.0, 26.0),
                new Fish("Brzanka sumatrzańska", "Puntigrus tetrazona", 6.0, 24.0, 30.0),
                new Fish("Danio różowe", "Danio roseus", 5.0, 18.0, 24.0),
                new Fish("Molinezja", "Poecilia sphenops", 7.0, 23.0, 28.0)
        ]
    }

    def "should sort fishes by name"() {
        when:
        fishes.sort(Fish.byName)

        then:
        fishes*.name == ["Brzanka sumatrzańska", "Danio różowe", "Gupik", "Molinezja", "Neon Innesa"]
    }

    def "should sort fishes by latin name"() {
        when:
        fishes.sort(Fish.byLatinName)

        then:
        fishes*.latinName == ["Danio roseus", "Paracheirodon innesi", "Poecilia reticulata", "Poecilia sphenops", "Puntigrus tetrazona"]
    }

    def "should sort fishes by length"() {
        when:
        fishes.sort(Fish.byLength)

        then:
        fishes*.length == [3.5, 4.0, 5.0, 6.0, 7.0]
    }

    def "should sort fishes by minimum temperature in descending order"() {
        when:
        fishes.sort(Fish.byMinTempDesc)

        then:
        fishes*.minWaterTemp == [24.0, 23.0, 22.0, 20.0, 18.0]
    }

    def "should sort fishes by maximum temperature"() {
        when:
        fishes.sort(Fish.byMaxTemp)

        then:
        fishes*.maxWaterTemp == [24.0, 26.0, 28.0, 28.0, 30.0]
    }
}

