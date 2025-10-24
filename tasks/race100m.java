/* Bieg na 100 metrów - symulacja. */

import java.util.Random;

class Track {
    private final int FINISH = 100;
    private boolean finished = false;
    private Runner winner = null;

    public boolean runStep(Runner runner) {
        
        if (finished) {
            return true;
        }

        runner.addStep(1);

        if (runner.getDistance() >= FINISH && !finished) {
            finished = true;
            winner = runner;
            System.out.println("\n" + runner.getName() + " dobiegl do mety! \n");
            notifyAll();
            return true;
        }

        notifyAll();

        try {
            wait(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return finished;
    }

    public boolean isFinished() {
        return finished;
    }

    public Runner getWinner() {
        return winner;
    }

    public void drawTrack(Runner[] runners) {
        int trackWidth = 50;
        System.out.println("=== WYSCIG 100m ===");
        for (Runner runner : runners) {
            int positionOnTrack = (int)((runner.getDistance() / 100.0) * trackWidth);
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-10s |", runner.getName()));
            for (int i = 0; i < trackWidth; i++) {
                if (i == positionOnTrack) sb.append("🏃");
                else sb.append("-");
            }
            sb.append("| ").append(runner.getDistance()).append("m");
            System.out.println(sb.toString());
        }
    }
}

class Runner implements Runnable {
    private final String name;
    private int distance = 0;
    private final Track track;
    private final Random random = new Random();

    public Runner(String name, Track track) {
        this.name = name;
        this.track = track;
    }

    public void addStep(int step) {
        distance += step;
        if (distance > 100) {
            distance = 100;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (!track.isFinished()) {
            // losowa szansa na ruch w tej turze
            if (random.nextInt(3) == 0) {
                synchronized (track) {
                    track.runStep(this); // krok na torze
                }
            }
            try {
                Thread.sleep(random.nextInt(200) + 50); // pauza, żeby animacja była czytelna
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {

        int numberOfRunners = 5;
        Track track = new Track();
        Runner[] runners = new Runner[numberOfRunners];
        Thread[] threads = new Thread[numberOfRunners];

        // tworzymy biegaczy i wątki
        for (int i = 0; i < numberOfRunners; i++) {
            runners[i] = new Runner("Biegacz_" + (i + 1), track);
            threads[i] = new Thread(runners[i]);
            threads[i].start();
        }

        // główny wątek odświeża tor w konsoli
        while (!track.isFinished()) {
            System.out.print("\033[H\033[2J"); // czyszczenie ekranu w konsoli
            System.out.flush();
            track.drawTrack(runners);
            Thread.sleep(200); // tempo odświeżania wizualizacji
        }

        // czekamy na zakończenie wszystkich wątków
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("KONIEC WYSCIGU");
        if (track.getWinner() != null)
            System.out.println("Zwyciezca: " + track.getWinner().getName());
    }
}
