package pl.unittest.thirteenth_lab;

class NumberController {
    private final NumberModel model;
    private final NumberView view;

    public NumberController(NumberModel model, NumberView view) {
        this.model = model;
        this.view = view;

        this.view.getClearButton().addActionListener(e -> {
            view.getOutputText().setText("");
            view.getNumberField().setText("");
        });

        // TODO: Brakuje jeszcze walidacji
        this.view.getReverseButton().addActionListener(e -> {
            int number = Integer.parseInt(view.getNumberField().getText());
            int reversed = model.reverseNumber(number);
            view.getOutputText().setText(String.format("%d", reversed));
        });

        // TODO: Brakuje jeszcze walidacji
        this.view.getOctalButton().addActionListener(e -> {
            int number = Integer.parseInt(view.getNumberField().getText());
            int octal = model.toOctal(number);
            view.getOutputText().setText(String.format("%d", octal));
        });
    }
}
