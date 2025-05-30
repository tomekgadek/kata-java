package pl.unittest.tweltfh;

/*
    Zdefiniuj interfejs o nazwie "GuessingGameExc" z jedną metodą:

    void isItTheNumber(int guess), która może zgłaszać dwa wyjątki kontrolowane:
    a) ArgumentTooLarge – jeśli podana liczba jest za duża,
    b) ArgumentTooSmall – jeśli podana liczba jest za mała.

    Implementacja tego interfejsu powinna wewnętrznie przechowywać szukaną liczbę.

    Metoda isItTheNumber(int) porównuje podaną wartość z szukaną liczbą i w razie niezgodności rzuca odpowiedni wyjątek.
*/

interface GuessingGameExc {
    int MIN = 0;
    int MAX = 1000;

    void isItTheNumber(int guess) throws GuessingGameExc.ArgumentTooLarge, GuessingGameExc.ArgumentTooSmall;

    class ArgumentTooLarge extends Exception {}
    class ArgumentTooSmall extends Exception {}
}

class GuessingGameExcImpl implements GuessingGameExc {
    private final int guess;

    public GuessingGameExcImpl(int guess) {
        this.guess = guess;
    }

    public void isItTheNumber(int check) throws GuessingGameExc.ArgumentTooLarge, GuessingGameExc.ArgumentTooSmall {
        final int MIN = GuessingGameExc.MIN;
        final int MAX = GuessingGameExc.MAX;

        if (this.guess < MIN || this.guess > MAX) {
            // 'check' must be between MIN and MAX
            return;
        }

        if (check < this.guess) {
            throw new ArgumentTooSmall();
        } else if (check > this.guess) {
            throw new ArgumentTooLarge();
        }

        // this is it ('check')! I found the number!
    }
}

class Main {

    public static void main(String[] args) {
        GuessingGameExc guessingGame = new GuessingGameExcImpl(50);
        int min = GuessingGameExc.MIN;
        int max = GuessingGameExc.MAX;
        int question = (min + max) / 2;

        for(int counter = 0; ; counter++) {

            try {
                guessingGame.isItTheNumber(question);

                System.out.println("this is it ('check')! I found the number!");
                System.out.println("I try : " + counter + " times.");
                System.out.println("This is " + question);

                break;
            }
            catch(GuessingGameExc.ArgumentTooLarge e) {
                max = question;
                question = (min + max) / 2;
            } catch( GuessingGameExc.ArgumentTooSmall e) {
                min = question;
                question = (min + max) / 2;
            }
        }
    }
}
