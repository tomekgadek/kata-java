package pl.unittest.thirteenth_lab;

class NumberController {
    private final NumberModel model;
    private final NumberView view;

    public NumberController(NumberModel model, NumberView view) {
        this.model = model;
        this.view = view;

        this.view.getIncrementButton().addActionListener(e -> {
            model.increment();
            view.setCounterText("Licznik: " + model.getValue());
        });
    }
}
