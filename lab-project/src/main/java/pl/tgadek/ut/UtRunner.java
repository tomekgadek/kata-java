package pl.tgadek.ut;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UtRunner {
    public static void runTests(Object object) {
        Class<?> clazz = object.getClass();
        System.out.println("Running tests for: " + clazz.getSimpleName());

        UtLibrary la = findAssertion(object, clazz);

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().startsWith("test")
                    && method.getParameterCount() == 0
                    && method.getReturnType().equals(void.class)) {

                int before = la.failureCount();

                try {
                    method.setAccessible(true);
                    method.invoke(object);

                    int after = la.failureCount();
                    if (after > before) {
                        System.out.println("  ✘ " + method.getName());
                    } else {
                        System.out.println("  ✔ " + method.getName());
                    }

                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println("  ✘ " + method.getName() + " threw: " + e.getCause());
                }
            }
        }

        la.report();
    }

    private static UtLibrary findAssertion(Object object, Class<?> clazz) {
        try {
            for (var field : clazz.getDeclaredFields()) {
                if (field.getType().equals(UtLibrary.class)) {

                    field.setAccessible(true);
                    UtLibrary la = (UtLibrary) field.get(object);
                    if (la == null) {
                        throw new IllegalStateException("UtLibrary field is null in " + clazz.getSimpleName());
                    }

                    return la;
                }
            }

            throw new IllegalStateException("Missing UtLibrary field in " + clazz.getSimpleName());

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
