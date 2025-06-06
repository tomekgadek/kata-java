package pl.unittest.thirteenth_lab;

class NumberModel {

    public int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }
        return reversed;
    }


    public int toOctal(int number) {
        int octal = 0;
        int multiplier = 1;
        while (number != 0) {
            octal += (number % 8) * multiplier;
            multiplier *= 10;
            number /= 8;
        }
        return octal;
    }
}
