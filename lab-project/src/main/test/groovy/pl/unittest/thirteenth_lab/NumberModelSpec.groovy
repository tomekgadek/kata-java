package pl.unittest.thirteenth_lab

import spock.lang.Specification
import spock.lang.Subject

class NumberModelSpec extends Specification {
    @Subject
    NumberModel numberModel = new NumberModel()

    def "should reverse number"() {
        expect:
        numberModel.reverseNumber(input) == expected

        where:
        input | expected
        5     | 5
        123   | 321
        1000  | 1
    }

    def "should convert decimal to octal"() {
        expect:
        numberModel.toOctal(input) == expected

        where:
        input | expected
        7     | 7
        8     | 10
        15    | 17
        64    | 100
    }
}
