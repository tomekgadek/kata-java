/** Wątki, które oddzielają liczby parzyste od nieparzystych. */

/*
    Wątek (ang. Thread) - część programu wykonywana współbieżnie w obrębie jednego procesu.
    W jednym procesie może istnieć wiele wątków.

    Różnica między zwykłym procesem a wątkiem polega na współdzieleniu przez wszystkie 
    wątki działające w danym procesie przestrzeni adresowej oraz wszystkich innych struktur 
    systemowych (np. listy otwartych plików, gniazd itp.) – z kolei procesy posiadają niezależne zasoby. 
*/

import java.util.ArrayList;
import java.util.List;

enum Find {
    EVEN, ODD
}

// Możemy implementować interfejs Runnable lub dziedziczyć po klasie Thread
class NumberSplitter implements Runnable {
    private List<Integer> digits;
    private List<Integer> resultDigits;
    private Find find;

    NumberSplitter(List<Integer> digits, Find find) {
        this.digits = digits;
        this.resultDigits = new ArrayList<>();
        this.find = find;
    }

    public void run() {
        if(find == Find.EVEN) {
            this.saveEvenNumbers();
        } else if(find == Find.ODD) {
            this.saveOddNumbers();
        }
    }

    private void saveEvenNumbers() {
        resultDigits.addAll(digits.stream().filter(digit -> digit % 2 == 0).toList());
    }

    private void saveOddNumbers() {
        resultDigits.addAll(digits.stream().filter(digit -> digit % 2 != 0).toList());
    }

    List<Integer> result() {
        return this.resultDigits;
    }
}

class Main {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        NumberSplitter evenSplitter = new NumberSplitter(numbers, Find.EVEN);
        NumberSplitter oddSplitter = new NumberSplitter(numbers, Find.ODD);

        Thread evenThread = new Thread(evenSplitter); // wątek odpowiedzialny za wydzielenie liczb parzystych
        Thread oddThread = new Thread(oddSplitter); // wątek odpowiedzialny za wydzielenie liczb nieparzystych

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join(); // czekamy na zakończenie działania wątku, potrzebujemy danych
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.printf("Even: %s \n", evenSplitter.result().toString());
        System.out.printf("Odd : %s \n", oddSplitter.result().toString());
    }
}
