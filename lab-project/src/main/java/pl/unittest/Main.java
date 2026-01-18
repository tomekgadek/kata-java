package pl.unittest;

import pl.tgadek.ut.UtRunner;
import pl.tgadek.ut_simple_tests.MathOperationTest;

public class Main {
    public static void main(String[] args) {
        System.out.println("ut library.");
        System.out.println("---");

        UtRunner.runTests(new MathOperationTest());

        System.out.println("---");
        System.out.println("lab project.");
    }
}