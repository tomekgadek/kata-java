/** Jak odczytać ciąg tekstowy ze standardowego wejścia? */

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Your name: ");
        String firstName = scanner.nextLine();

        System.out.printf("Hello %s! \n", firstName);
    }
}
