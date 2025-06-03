package pl.unittest.thirteenth_lab;

class NumberModel {
    private int counter = 0;

    public int getValue() {
        return counter;
    }

    public void increment() {
        counter++;
    }

    public int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }
        return reversed;
    }

}
