package pl.unittest.first_lab

import spock.lang.Specification
import spock.lang.Unroll

class FactorialSpec extends Specification {
    def factorial = new Factorial()

    @Unroll
    def "Natural logarithm of factorial of #digit should be approximately #expectedLnFactorial"() {
        expect:
        Math.abs(factorial.calculateLnFactorial(digit) - expectedLnFactorial) < 0.0001

        where:
        digit || expectedLnFactorial
        1     || Math.log(1)
        5     || Math.log(120)
        6     || Math.log(720)
        13    || Math.log(6227020800)
        15    || Math.log(1307674368000)
        20    || Math.log(2432902008176640000)
    }
}
