/** Jak zapisać dane do pliku tekstowego? */

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;

class Square {

    private int size = 0;
    private int sizeWithoutBorder = 0;
    private final String enter = "\n";
    private final String space = " ";
    private final String cornerSign = "#";
    private final String borderSign = "O";

    Square(final int size) {
        this.size = (size < 2 ? 2 : size); 
        this.sizeWithoutBorder = this.size - 2;
    }

    String buildSquare() {

        final String firstEndLine = this.prepareFirstEndLine();
        final String line = prepareLine();
        
        StringBuilder squareAsText = new StringBuilder(firstEndLine)
            .append(line.repeat(this.sizeWithoutBorder))
            .append(firstEndLine)
        ;
        
        return squareAsText.toString();
    }

    private String prepareFirstEndLine() {
        return String.join("", this.cornerSign, this.borderSign.repeat(this.sizeWithoutBorder), this.cornerSign, this.enter);
    }

    private String prepareLine() {
        return String.join("", borderSign, this.space.repeat(this.sizeWithoutBorder), this.borderSign, this.enter);
    }

    public String toString() {
        return this.buildSquare();
    }
}

class Main {

    public static void main(String[] args) {

        try {

            PrintWriter file = new PrintWriter("../static/task_file_002.txt");

            file.println(new Square(9));
            file.close();

        } catch(FileNotFoundException e) {

            e.printStackTrace();
        } finally {

            System.out.println();
            System.out.println("Done.");
        }
    }
}
