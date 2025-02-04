/** Jak odczytać dane z pliku tekstowego? */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        File file = new File("../static/task_file_001.txt");

        try(Scanner scanner = new Scanner(file)) {

            String firstLine = scanner.nextLine(); // first line
            System.out.println(firstLine);

            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine()); // other lines
            }

            System.out.println();
            System.out.println("Done.");

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
