/** Pirwszy obiekt */

class Main {

    private void sayHello() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.sayHello();
    }
}

/**
 * Notatki:
 * 
 * new - polecenie 'new' tworzy instancję klasy czyli obiekt.
 * private - metody prywatne (private) można wywoływać wyłącznie z wnętrza klasy, w której
 * są zadeklarowane. Inni nie mają do nich dostępu.
 * 
 * ELEMENTY PUBLICZNE A PRYWATNE
 * 
 * Klasa składa się z publicznego interfejsu i prywatnej implementacji.
 * 
 * Interfejs to dopuszczalne metody współpracy.
 * 
 * O co chodzi z tą 'Hermetyzacją'/'Enkapsulacją'? Ukrywamy implementację. Dzięki temu nikt nie zmieni
 * stanu naszego obiektu bez jego wiedzy. Możemy łatwiej wykrywać błędy - sami zmieniamy obiekt.
 * 
 */
