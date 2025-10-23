/* 
    Gra w statki.

    Dwie jednostki na planszy atakują się na zmianę, aż jedna z nich zginie.
    Każda jednostka ma 50 punktów życia i zadaje losowe obrażenia w zakresie 
    5-10 punktów. Po każdym ataku wyświetlany jest komunikat o zadanych 
    obrażeniach i pozostałych punktach życia przeciwnika.
    Gdy jedna z jednostek straci wszystkie punkty życia, gra się 
    kończy.
*/

class Ship {
    private String name;
    private int hp;

    public Ship(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) {
            hp = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }
}

class Arena {
    private boolean firstShipTurn = true;
    private boolean battleOver = false;

    public synchronized void attack(Ship attacker, Ship defender) {
        while (battleOver) return;

        while ((attacker.getName().equals("Statek A") && !firstShipTurn) ||
               (attacker.getName().equals("Statek B") && firstShipTurn)) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }

        int dmg = (int)(Math.random() * 6) + 5; // random 5–10
        defender.takeDamage(dmg);

        System.out.printf("%s atakuje %s za %d obrazen (pozostalo HP: %d)%n",
                attacker.getName(), defender.getName(), dmg, defender.getHP());

        if (!defender.isAlive()) {
            System.out.println("# " + attacker.getName() + " WYGRAL!");
            battleOver = true;
            notifyAll();
            return;
        }

        firstShipTurn = !firstShipTurn;
        notifyAll();
    }
}

class Fighter implements Runnable {
    private Ship self;
    private Ship opponent;
    private Arena arena;

    public Fighter(Ship self, Ship opponent, Arena arena) {
        this.self = self;
        this.opponent = opponent;
        this.arena = arena;
    }

    @Override
    public void run() {
        while (self.isAlive() && opponent.isAlive()) {
            arena.attack(self, opponent);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Ship a = new Ship("Statek A", 50);
        Ship b = new Ship("Statek B", 50);
        Arena arena = new Arena();

        Thread t1 = new Thread(new Fighter(a, b, arena));
        Thread t2 = new Thread(new Fighter(b, a, arena));

        t1.start();
        t2.start();
    }
}
