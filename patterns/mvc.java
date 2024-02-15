/** Architektoniczny wzorzec projektowy: Model-View-Controller (MVC). */

/*
 * Model-View-Controller zakłada podział aplikacji na trzy główne części:
 * 
 * Model: Reprezentuje dane i logikę biznesową aplikacji.
 * View: Wyświetla dane użytkownikowi.
 * Controller: Obsługuje żądania użytkownika i aktualizuje model oraz widok.
 * 
 */

class Model {

    private int a;
    private int b;

    Model() {
        this.a = 0;
        this.b = 0;
    }

    void update(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int addNumbers() {
        return a + b;
    }
}

class View {

    void displayResult(int a, int b, int result) {
        System.out.printf("+-----+-----+-----+-----+-----+ \n");
        System.out.printf("|%5d|  %c  |%5d|  %c  |%5d| \n", a, '+', b, '=', result);
        System.out.printf("+-----+-----+-----+-----+-----+ \n");
    }
}

class Controller {

    private Model model;
    private View view;

    Controller(final Model model, final View view) {
        this.model = model;
        this.view = view;
    }

    void addNumbersAndUpdateView(int a, int b) {

        model.update(a, b);
        int result = model.addNumbers();

        view.displayResult(a, b, result);
    }
}

class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(model, view);

        controller.addNumbersAndUpdateView(2, 4);
        controller.addNumbersAndUpdateView(-1, 6);
        controller.addNumbersAndUpdateView(0, 4);
        controller.addNumbersAndUpdateView(-1, -4);
    }
}
