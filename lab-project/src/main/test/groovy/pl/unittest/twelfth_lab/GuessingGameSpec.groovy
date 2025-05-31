package pl.unittest.twelfth_lab

import spock.lang.Specification
import spock.lang.Unroll

class GuessingGameSpec extends Specification {

    @Unroll
    def "should throw ArgumentTooSmall when guess #guess is smaller than target #target"() {
        given:
        def game = new GuessingGameExcImpl(target)

        when:
        game.isItTheNumber(guess)

        then:
        thrown(GuessingGameExc.ArgumentTooSmall)

        where:
        target | guess
        50     | 25
        100    | 50
        75     | 30
    }

    @Unroll
    def "should throw ArgumentTooLarge when guess #guess is larger than target #target"() {
        given:
        def game = new GuessingGameExcImpl(target)

        when:
        game.isItTheNumber(guess)

        then:
        thrown(GuessingGameExc.ArgumentTooLarge)

        where:
        target | guess
        50     | 75
        100    | 150
        75     | 100
    }

    def "should not throw exception when guess matches target"() {
        given:
        def target = 50
        def game = new GuessingGameExcImpl(target)

        when:
        game.isItTheNumber(target)

        then:
        noExceptionThrown()
    }

    def "should handle invalid target number gracefully"() {
        given:
        def game = new GuessingGameExcImpl(invalidTarget)

        when:
        game.isItTheNumber(50)

        then:
        thrown(GuessingGameExc.InvalidArgumentException)

        where:
        invalidTarget << [-1, 1001]
    }
}

