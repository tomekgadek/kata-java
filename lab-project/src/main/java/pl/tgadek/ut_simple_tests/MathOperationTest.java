package pl.tgadek.ut_simple_tests;

import pl.tgadek.ut.UtLibrary;

public class MathOperationTest {

    private final UtLibrary ut = new UtLibrary();

    void testPositivePlusNegativeIntegerAddition() {
        // Arrange
        var firstDigit = 5;
        var secondDigit = -1;
        var expectedResult = 4;

        // Act
        int result = MathOperation.add(firstDigit, secondDigit);

        // Assert
        ut.assertEqual(result, expectedResult, "5 + (-1) should equal 4");
    }

    void testZeroPlusPositiveIntegerAddition() {
        // Arrange
        var firstDigit = 0;
        var secondDigit = 3;
        var expectedResult = 3;

        // Act
        int result = MathOperation.add(firstDigit, secondDigit);

        // Assert
        ut.assertEqual(result, expectedResult, "0 + 3 should equal 3");
    }
}