/** Typy pierwotne w języku Java. */


// Typ pierwotny - typ służący jako baza do definiowania nowych typów.

/**
 * 
 * - byte (liczba całkowita - 1bajt)
 * - short (liczba całkowita - 2bajty)
 * - int (liczba całkowita - 4bajty)
 * - long (liczba całkowita - 8bajtów)
 * - float (liczba zmiennoprzecinkowa - 4bajty)
 * - double (liczba zmiennoprzecinkowa - 8bajtów)
 * - char (znak - 2bajty)
 * - boolean(typ logiczny - 1bajt)
 * 
 * W języku Java nie ma odpowiednika typów unsigned. Wszystkie są ze znakiem!
 * 
 */
class Main {

    public static void main(String[] args) {

        int age = 18;
        long level = 1234L;
        float salary = 2500.99F;
        boolean isMan = true;
        char woman = 'W';

        long octal = 011; // ósemkowo(11) = dziesiętnie(9)
        int hex = 0xC; // hex(C) = dziesiętnie(12)

        System.out.println(octal);
        System.out.println(hex);
    }
}

/**
 * Co to jest typ?
 * 
 * Typ to opis rodzaju, struktury i zakresu wartości, jakie może przyjmowąć dany literał, zmienna,
 * stała, argument lub wynik funkcji. Typ określa, ile pamięci jest przydzielane oraz jak na niej
 * operować (np. typ 'double' to 8 bajtów).
 * 
 */
