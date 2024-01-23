/** Jak odczytać dane ze standardowego wejścia? */

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("a = ");
        int variableA = scanner.nextInt();

        System.out.print("b = ");
        int variableB = scanner.nextInt();

        if(variableA > variableB) {
            System.out.println("a > b");
        } else if(variableA < variableB) {
            System.out.println("a < b");
        } else {
            System.out.println("a == b");
        }
    }
}