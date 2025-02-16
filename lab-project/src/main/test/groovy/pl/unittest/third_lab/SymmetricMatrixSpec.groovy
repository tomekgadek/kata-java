package pl.unittest.third_lab

import spock.lang.Specification

class SymmetricMatrixSpec extends Specification {

    def "should correctly store and retrieve values in a symmetric matrix"() {
        given: "A symmetric matrix of size 3"
        def matrix = new SymmetricMatrix(3)

        when: "Setting symmetric values in the matrix"
        matrix.set(1, 1, 2)
        matrix.set(2, 2, 6)
        matrix.set(3, 3, 9)
        matrix.set(3, 1, 3)
        matrix.set(2, 3, 7)
        matrix.set(1, 2, 1)

        then: "Matrix should maintain symmetry"
        matrix.get(1, 1) == 2
        matrix.get(2, 2) == 6
        matrix.get(3, 3) == 9
        matrix.get(3, 1) == 3
        matrix.get(1, 3) == 3
        matrix.get(2, 3) == 7
        matrix.get(3, 2) == 7
        matrix.get(1, 2) == 1
        matrix.get(2, 1) == 1
    }

    def "should correctly verify symmetric matrix property"() {
        given: "A symmetric matrix of size 3"
        def matrix = new SymmetricMatrix(3)

        when: "Setting values in the matrix"
        matrix.set(1, 2, 5)
        matrix.set(2, 3, 8)
        matrix.set(3, 1, 4)

        then: "Values should be symmetric"
        matrix.get(1, 2) == 5
        matrix.get(2, 1) == 5
        matrix.get(2, 3) == 8
        matrix.get(3, 2) == 8
        matrix.get(3, 1) == 4
        matrix.get(1, 3) == 4
    }
}
