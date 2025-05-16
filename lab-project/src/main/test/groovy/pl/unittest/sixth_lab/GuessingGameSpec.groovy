package pl.unittest.sixth_lab

import pl.unittest.sixth.GuessingGameImpl
import pl.unittest.sixth.Search
import spock.lang.*

class GuessingGameSpec extends Specification {

    def "should correctly guess value and mark as found"() {
        given:
        def game = new GuessingGameImpl(1, 10, 7)

        expect:
        !game.isSolved()

        when:
        def result = game.checkGuess(7)

        then:
        result
        game.isSolved()
        game.getNumberOfAttempts() == 1
    }

    def "should return correct range boundaries"() {
        given:
        def game = new GuessingGameImpl(5, 20, 10)

        expect:
        game.getMin() == 5
        game.getMax() == 20
    }

    def "should return true if proposal is greater or smaller"() {
        given:
        def game = new GuessingGameImpl(1, 10, 5)

        expect:
        game.checkIfGreater(6)
        !game.checkIfGreater(4)
        game.checkIfSmaller(4)
        !game.checkIfSmaller(6)
    }

    def "search should find the correct value"() {
        given:
        def game = new GuessingGameImpl(1, 100, 25)
        def strategy = new Search()

        when:
        strategy.search(game)

        then:
        game.isSolved()
        game.getNumberOfAttempts() > 0
        game.getNumberOfAttempts() <= 10
    }

    def "search should work for value at boundary (min)"() {
        given:
        def game = new GuessingGameImpl(1, 200, 1)
        def strategy = new Search()

        when:
        strategy.search(game)

        then:
        game.isSolved()
        game.getNumberOfAttempts() > 0
    }

    def "search should work for value at boundary (max)"() {
        given:
        def game = new GuessingGameImpl(1, 200, 200)
        def strategy = new Search()

        when:
        strategy.search(game)

        then:
        game.isSolved()
        game.getNumberOfAttempts() > 0
    }
}

