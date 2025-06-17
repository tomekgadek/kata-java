package pl.unittest.fourteenth_lab;

public enum Ui {

    APP_TITLE("Punkty Materialne 2D"),
    LOG_BUTTON("Skala logarytmiczna"),
    LIN_BUTTON("Skala liniowa")
    ;

    private final String text;

    Ui(String text) {
        this.text = text;
    }

    public String message() {
        return this.text;
    }
}
