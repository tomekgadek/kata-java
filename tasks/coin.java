/** Symulacja rzutu monetą. */

import java.util.Random;

class Coin {

    private Random rand;

    public Coin() {
        rand = new Random();
    }

    public String headOrTail() {
        return rand.nextInt(2) > 0 ? "HEAD" : "TAIL";
    }
}

class Main {

    public static void main(String[] args) {
        var coin = new Coin();

        for(int i = 0; i < 10; i++) {
            System.out.printf("%02d) %s \n", i+1, coin.headOrTail());
        }

        System.out.println();
    }
}
