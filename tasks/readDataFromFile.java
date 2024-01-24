/** Jak odczytać dane z pliku tekstowego? */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        try {

            File file = new File("../static/task_file_001.txt");
            Scanner scanner = new Scanner(file);

            String firstLine = scanner.nextLine(); // first line
            System.out.println(firstLine);

            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine()); // other lines
            }

            scanner.close();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println();
            System.out.println("Done.");
        }
    }
}