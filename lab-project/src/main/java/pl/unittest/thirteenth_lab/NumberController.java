package pl.unittest.thirteenth_lab;

import java.util.List;

class NumberController {

    private FieldsValidator fieldsValidator;

    private void init() {
        List<Validator> validators = List.of(new EmptyFieldValidator(), new DigitFieldValidator());
        this.fieldsValidator = new FieldsValidator(validators);
    }

    public NumberController(NumberModel model, NumberView view) {

        view.getClearButton().addActionListener(e -> {
            view.getOutputText().setText("");
            view.getNumberField().setText("");
        });

        view.getReverseButton().addActionListener(e -> {
            this.init();

            if(!fieldsValidator.isValid(view.getNumberField().getText())) {
                view.showErrorMessage(String.join(" ", fieldsValidator.errorMessages()));
                return ;
            }

            int number = Integer.parseInt(view.getNumberField().getText());
            int reversed = model.reverseNumber(number);
            view.getOutputText().setText(String.format("%d", reversed));
        });

        view.getOctalButton().addActionListener(e -> {
            this.init();

            if(!fieldsValidator.isValid(view.getNumberField().getText())) {
                view.showErrorMessage(String.join(" ", fieldsValidator.errorMessages()));
                return ;
            }

            int number = Integer.parseInt(view.getNumberField().getText());
            int octal = model.toOctal(number);
            view.getOutputText().setText(String.format("%d", octal));
        });
    }
}
