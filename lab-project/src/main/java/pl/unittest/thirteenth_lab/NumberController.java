package pl.unittest.thirteenth_lab;

import java.util.List;

class NumberController {

    public NumberController(NumberModel model, NumberView view) {

        List<Validator> validators = List.of(new EmptyFieldValidator(), new DigitFieldValidator());

        view.getClearButton().addActionListener(e -> {
            view.getOutputText().setText("");
            view.getNumberField().setText("");
        });

        view.getReverseButton().addActionListener(e -> {

            int number = Integer.parseInt(view.getNumberField().getText());
            int reversed = model.reverseNumber(number);
            view.getOutputText().setText(String.format("%d", reversed));
        });

        view.getOctalButton().addActionListener(e -> {

            int number = Integer.parseInt(view.getNumberField().getText());
            int octal = model.toOctal(number);
            view.getOutputText().setText(String.format("%d", octal));
        });
    }

}
