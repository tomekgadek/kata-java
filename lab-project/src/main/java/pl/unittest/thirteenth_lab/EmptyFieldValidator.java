package pl.unittest.thirteenth_lab;

public class EmptyFieldValidator implements Validator {

    @Override
    public boolean isValid(String value) {
        return value != null && !value.isBlank();
    }

    @Override
    public String errorMessage() {
        return "Pole nie może być puste.";
    }
}
