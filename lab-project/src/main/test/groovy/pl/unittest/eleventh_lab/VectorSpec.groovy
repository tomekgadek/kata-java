package pl.unittest.eleventh_lab

import spock.lang.*

class VectorSpec extends Specification {

    def "Vector.size() returns a value between 5 and 10 inclusive"() {
        expect:
        (1..100).every {
            def size = Vector.size()
            size >= 5 && size <= 10
        }
    }

    def "Vector.fill fills the entire array with non-zero doubles"() {
        given:
        int length = 8
        double[] vector = new double[length]

        when:
        Vector.fill(vector)

        then:
        vector.every { it >= 0.0 && it < 1.0 }  // Random.nextDouble() returns [0.0, 1.0)
    }

    def "Vector.fill does not throw exceptions and fully fills the array"() {
        given:
        int length = 7
        double[] vector = new double[length]

        when:
        Vector.fill(vector)

        then:
        noExceptionThrown()
        vector.length == length

    }

    def "Vector.show prints all vector elements and then stops"() {
        given:
        def vector = [0.1d, 0.2d, 0.3d] as double[]
        def output = new ByteArrayOutputStream()
        System.setOut(new PrintStream(output))

        when:
        Vector.show(vector)

        then:
        def printed = output.toString("UTF-8")
        vector.eachWithIndex { val, i ->
            assert printed.contains(String.format("V[%d] = %.2f", i, val))
        }

        cleanup:
        System.setOut(System.out)
    }
}
