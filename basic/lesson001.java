/** Pierwszy program w języku Java */

class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

/**
 * Notatki:
 * 
 * Kompilator języka Java nazywa się 'javac'.
 * Wirtualna maszyna Java nazywa się 'java'.
 * 
 * Popularne zintegrowane środowiska programistyczne, które poprawiają komfort pracy:
 * - Eclipse
 * - NetBeans
 * - IntelliJ IDEA
 * 
 * Co to jest klasa?
 * 
 * Klasa to przepis (plan, stempel) na tworzenie obiektów. Klasa to plany konstrukcyjne np.
 * samochodu, konkretny egzemplarz auuta to już obiekt.
 * 
 * Co to jest metoda statyczna?
 * 
 * Słowo 'static' powoduje, że metoda istnieje, choć nie mamy obiektu.
 * 
 * Jaka jest idea programowania w języku Java?
 * 
 * Program składa się z klas. Klasa zwiera metody. Metody zawierają instrukcje. W Java nie ma
 * programów bez klas.
 * 
 * W jaki sposób kompilować i uruchamiać kod java?
 * 
 * Nasz kod znajduje się w pliku 'lesson001.java', więc kompilacja odbywa się w następujący sposób:
 * 
 * javac lesson001.java
 * 
 * Powstają pliki z rozszerzeniem '.class'. W plikach '.class' zawarty jest kod bajtowy (B-kod). Nie
 * jest to kod maszynowy! Do uruchomienia potrzebna będzie wirtualna mszyna Java, czyli JVM. Ona
 * B-kod interpretuje!
 * 
 * Program uruchamiamy za pomocą następującego polecenia:
 * 
 * java Main
 * 
 * JVM poszukuje w klasie 'Main' metody z takim nagłówkiem: 'public static void main(String[] args)'
*/