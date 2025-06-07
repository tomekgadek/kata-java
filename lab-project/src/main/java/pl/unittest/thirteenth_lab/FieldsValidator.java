package pl.unittest.thirteenth_lab;

import java.util.ArrayList;
import java.util.List;

class FieldsValidator {

    private final List<Validator> validators;
    private final List<String> messages;

    public FieldsValidator(List<Validator> validators) {

        this.validators = validators;
        this.messages = new ArrayList<>();
    }

    public boolean isValid(String field) {

        this.validators.forEach(validator -> {
            if(!validator.isValid(field)) {
                this.messages.add(validator.errorMessage());
            }
        });

        return this.messages.isEmpty();
    }

    public List<String> errorMessages() {
        return this.messages;
    }
}
