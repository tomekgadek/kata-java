/** Kreacyjny wzorzec projektowy: Metoda wytwórcza (Factory method). */

abstract class Pizza {

    protected String name;

    Pizza(final String name) {
        this.name = name;
    }

    abstract void make();
    abstract void box();
}

class DeluxePizza extends Pizza {

    DeluxePizza() {
        super("Deluxe");
    }

    @Override
    void make() {
        System.out.printf("Prepare %s \n", this.name);
    }

    @Override
    void box() {
        System.out.printf("Box %s \n", this.name);
    }
}

class HawaiianPizza extends Pizza {

    HawaiianPizza() {
        super("Hawaiian");
    }

    @Override
    void make() {
        System.out.printf("Prepare %s \n", this.name);
    }

    @Override
    void box() {
        System.out.printf("Box %s \n", this.name);
    }
}

interface SimpleFactory {

    enum PizzaType {
        Deluxe, 
        Hawaiian,
        Simple
    }

    Pizza createPizza(PizzaType type);
}

class DominiumPizzaFactory implements SimpleFactory {

    @Override
    public Pizza createPizza(PizzaType type) {

        var pizza = switch(type) {
            case Deluxe -> new DeluxePizza();
            case Hawaiian -> new HawaiianPizza();
            default -> throw new IllegalArgumentException("Pizza doesn't exist!");
        };

        return pizza;
    }
}

class PizzaStore {

    private SimpleFactory factory;

    PizzaStore(final SimpleFactory factory) {
        this.factory = factory;
    }

    Pizza orderPizza(final SimpleFactory.PizzaType type) {
        
        var pizza = factory.createPizza(type);

        pizza.make();
        pizza.box();

        return pizza;
    }
}

class Main {

    public static void main(String[] args) {

        SimpleFactory factory = new DominiumPizzaFactory();
        
        PizzaStore store = new PizzaStore(factory);
        store.orderPizza(SimpleFactory.PizzaType.Hawaiian);
    }
}