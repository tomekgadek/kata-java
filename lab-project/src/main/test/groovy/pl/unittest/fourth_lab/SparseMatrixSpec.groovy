package pl.unittest.fourth_lab

import spock.lang.Specification

class SparseMatrixSpec extends Specification {

    def "should correctly set and get values within allowed constraints"() {
        given: "A new sparse matrix"
        def matrix = new SparseMatrix(3)
        matrix.set(1, 1, 5)
        matrix.set(1, 2, 1)
        matrix.set(3, 3, 6)
        matrix.set(1, 2, 6) // Update existing value
        matrix.set(3, 2, 8)

        expect: "Values should be retrieved correctly"
        matrix.get(1, 1) == 5
        matrix.get(1, 2) == 6
        matrix.get(3, 3) == 6
        matrix.get(3, 2) == 8
    }

    def "should enforce non-zero value limit"() {
        given: "A new sparse matrix close to the non-zero value limit"
        def matrix = new SparseMatrix(3)
        matrix.set(1, 1, 5)
        matrix.set(1, 2, 1)
        matrix.set(3, 3, 6)
        matrix.set(1, 2, 6)
        matrix.set(3, 2, 8)
        def exceeded = matrix.set(3, 1, 9) // This should exceed 50% limit

        expect: "Matrix should not allow more than 50% non-zero values"
        !exceeded // Assuming set() returns false if the limit is exceeded
    }

    def "should throw exception for out-of-bounds assignments"() {
        given: "A new sparse matrix with defined size"
        def matrix = new SparseMatrix(3)

        when: "Setting a value outside the allowed range"
        matrix.set(4, 1, 9)

        then: "An IndexOutOfBoundsException should be thrown"
        thrown(IndexOutOfBoundsException)
    }
}

