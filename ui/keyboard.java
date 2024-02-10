/** Obsługa zdarzeń z klawiatury. */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

class Window extends JFrame implements KeyListener {

    private int counter = 0;
    private String userInput = "";
    private final String secret = "matrix";

    Window() {
        super("Guess the word");
        setPreferredSize(new Dimension(300, 100));
        addKeyListener(this);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // reaguje, gdy przycisk zostanie zwolniony, który wcześniej został wciśnięty
    public void keyReleased(KeyEvent keyEvent) {
        
        char sign = keyEvent.getKeyChar();
        if(counter < secret.length()) {
            checkSecret(sign);
        }
    }

    private void checkSecret(char sign) {
        System.out.print(sign);

        // dopóki znaki się zgadzają to kontynuuj
        if(sign == secret.charAt(counter)) {
            this.counter++;
            this.userInput += sign;
        } else { // jeżeli przynajmniej jeden znak będzie niezgodny to resetuj licznik i dane
            System.out.println();
            this.counter = 0;
            this.userInput = "";
        }

        // jeżeli dane wejściowe są identyczne, jak wartość 'secret' to zmień tytuł okna
        if(userInput.equals(secret)) {
            System.out.println("\nThis is it! Congratulations!!!");
            setTitle("This is it! Congratulations!!!");
        }
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        
    }
}

class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Window(); // tworzymy okienko
            }
        });
    }
}
