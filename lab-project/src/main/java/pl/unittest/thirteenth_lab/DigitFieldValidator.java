package pl.unittest.thirteenth_lab;

public class DigitFieldValidator implements Validator {


    @Override
    public boolean isValid(String value) {
        return String.valueOf(value).matches("[0-9]+");
    }

    @Override
    public String errorMessage() {
        return "Pole nie zawiera liczby.";
    }
}
