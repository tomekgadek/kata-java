package pl.tgadek.ut;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UtLibrary {
    private final List<String> assertionResults = new ArrayList<>();

    public <T> void assertEqual(T actual, T expected, String message) {
        if (!Objects.equals(actual, expected)) {
            assertionResults.add("Assertion failed: %s (expected: %s, actual: %s)"
                    .formatted(message, expected, actual));
        }
    }

    int failureCount() {
        return assertionResults.size();
    }

    void report() {
        if (assertionResults.isEmpty()) {
            System.out.println("All assertions passed successfully");
            return;
        }
        System.out.println("Assertion results:");
        assertionResults.forEach(System.out::println);
    }
}
