/** Zastosowanie interfejsów na przykładzie kontrolera do gier. */

interface Joystick {

    Joystick up();
    Joystick down();
    Joystick left();
    Joystick right();
}

class Controller implements Joystick {

    int x = 0;
    int y = 0;

    Controller(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Controller up() {
        this.y++;
        return this;
    }

    public Controller down() {
        this.y--;
        return this;
    }

    public Controller left() {
        this.x--;
        return this;
    }

    public Controller right() {
        this.x++;
        return this;
    }

    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}

class Main {

    public static void main(String[] args) {

        Controller gamePad = new Controller(0, 0);

        gamePad.up().up().up().left().left();
        assert gamePad.equals("(-2, 3)");

        gamePad.right().down();
        assert gamePad.equals("(-1, 2)");

        gamePad.right().down().down();
        assert gamePad.equals("(0, 0)");
    }
}