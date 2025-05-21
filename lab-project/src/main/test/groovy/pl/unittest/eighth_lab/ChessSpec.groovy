package pl.unittest.eighth_lab

import spock.lang.Specification
import spock.lang.Unroll

class GameRulesSpec extends Specification {

    @Unroll
    def "Knight move from #source to #destination should be #expected"() {
        given:
        def knight = new GameRules.Knight()

        expect:
        knight.isValidMove(source, destination) == expected

        where:
        source                         | destination                      || expected
        new GameRules.Point(0, 0)      | new GameRules.Point(2, 1)        || true
        new GameRules.Point(0, 0)      | new GameRules.Point(1, 2)        || true
        new GameRules.Point(0, 0)      | new GameRules.Point(3, 3)        || false
        new GameRules.Point(-1, -1)    | new GameRules.Point(0, 1)        || true
        new GameRules.Point(-1, -1)    | new GameRules.Point(1, 0)        || true
        new GameRules.Point(1, 1)      | new GameRules.Point(2, 3)        || true
    }

    @Unroll
    def "Queen move from #source to #destination should be #expected"() {
        given:
        def queen = new GameRules.Queen()

        expect:
        queen.isValidMove(source, destination) == expected

        where:
        source                         | destination                      || expected
        new GameRules.Point(0, 0)      | new GameRules.Point(0, 7)        || true
        new GameRules.Point(0, 0)      | new GameRules.Point(7, 0)        || true
        new GameRules.Point(0, 0)      | new GameRules.Point(7, 7)        || true
        new GameRules.Point(2, 2)      | new GameRules.Point(5, 4)        || false
        new GameRules.Point(1, 1)      | new GameRules.Point(2, 2)        || true
        new GameRules.Point(-3, 1)     | new GameRules.Point(-1, -1)      || true
    }
}

