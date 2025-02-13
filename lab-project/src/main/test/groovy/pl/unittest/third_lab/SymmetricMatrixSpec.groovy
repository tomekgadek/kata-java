package pl.unittest.third_lab

import spock.lang.Specification
import spock.lang.Unroll

// TODO: Tetsy do poprawy!!!

class SymmetricMatrixSpec extends Specification {

    @Unroll
    def "should correctly set and get matrix values"(int row, int col, int value) {
        given: "A symmetric matrix of size 3"
        def matrix = new SymmetricMatrix(3)

        when: "Setting values in the matrix"
        matrix.set(row, col, value)

        then: "Values should be retrieved correctly"
        matrix.get(row, col) == value
        matrix.get(col, row) == value // Symmetric property

        where:
        row | col | value
        1   | 1   | 2
        2   | 2   | 6
        3   | 3   | 9
        3   | 1   | 3
        2   | 3   | 7
        1   | 2   | 1
    }
}
