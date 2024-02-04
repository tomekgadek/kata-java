/** Generator ciągu Fibonacciego. */

import java.util.Arrays;

class Fibonacci {

    private final int size;
    private int[] sequence;

    Fibonacci(int size) {
        this.size = size < 2 ? 2 : size;
        this.sequence = new int[this.size];
    }

    int[] calculate() {

        sequence[0] = 1;
        sequence[1] = 1;

        for(int i = 2; i < this.size; i++) {
            sequence[i] = sequence[i-1] + sequence[i-2];
        }

        return sequence;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.calculate());
    }
}

class Main {

    public static void main(String[] args) {

        System.out.println(new Fibonacci(7));
    }
}
