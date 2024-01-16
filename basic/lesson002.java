/** Z jakich elementów składa się funkcja main()? */

class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

/**
 * Notatki:
 * 
 * 'public' to modyfikator dostępu, ten pozwala każdemu na wykonanie metody.
 * 'static' wiąże metodę z klasą, nie jest ona powiązana z żadną instancją klasy (obiektem).
 * 'void' metoda określa w ten spowób, że nie zwraca niczego.
 * 'main' to nazwa metody.
 * String[] args to lista parametrów (tu jeden parametr: tablica obiektów klasy String, który
 * we wnętrzu metody będzie dostępny poprzez nazwę 'args').
 * 
 * Ważne informacje:
 * 
 * Sygnatura metody - to nazwa metody oraz lista jej parametrów.
 * Nagłówek metody - to sygnatura metody i modyfikatory (np. public, czy static), typ wyniku oraz
 * lista zgłaszanych wyjątków.
 * Ciało metody - rozdzielone średnikami instrukcje zawarte w nawiasach klamrowych '{' i '}'.
 * Deklaracja metody - nagłówek metody oraz jej ciało.
 * 
 */
