/** Jak przeciążyć nazwę funkcji? */

class Space {

    static void point(int x) {
        System.out.printf("1D: x = %d \n", x);
    }

    static void point(int x, int y) {
        System.out.printf("2D: x = %d, y = %d \n", x, y);
    }

    static void point(int x, int y, int z) {
        System.out.printf("3D: x = %d, y = %d, z = %d \n", x, y, z);
    }
}

class Main {

    public static void main(String[] args) {
        Space.point(2); // 1D
        Space.point(1, 2); // 2D
        Space.point(4, 2, 7); // 3D
    }
}
