/*
    GRA W ZAPAŁKI

    ZASADY GRY:
    Na stole znajduje się określona liczba zapałek (np. 16).
    Dwóch graczy na zmianę zabiera ze stosu 1, 2 lub 3 zapałki.
    Przegrywa ten, kto weźmie ostatnią zapałkę.
    Celem gracza jest doprowadzenie przeciwnika do sytuacji,
    w której musi wziąć ostatnią zapałkę.

    Program pozwala na rozgrywkę między dwoma użytkownikami.
    W każdej turze wyświetlana jest aktualna liczba zapałek.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Match {}

interface IMatchstickGame {
    int getMatchCount();
    void removeLastMatch();
}

class MatchstickGame implements IMatchstickGame {
    private final List<Match> matches;

    public MatchstickGame(int initialMatches) {
        matches = new ArrayList<>();
        for (int i = 0; i < initialMatches; i++) {
            matches.add(new Match());
        }
    }

    @Override
    public int getMatchCount() {
        return matches.size();
    }

    @Override
    public void removeLastMatch() {
        if (!matches.isEmpty()) {
            matches.remove(matches.size() - 1);
        }
    }

    @Override
    public String toString() {
        char[] pattern = {'o', '|', '|'};
        StringBuilder board = new StringBuilder("\n");
        for (char c : pattern) {
            for (int j = 0; j < matches.size(); j++) {
                board.append(" ").append(c).append(" ");
            }
            board.append("\n");
        }
        board.append("\n");
        return board.toString();
    }
}

class Player {
    private final String name;
    private boolean winner;

    public Player(String name) {
        this.name = name;
        this.winner = false;
    }

    public String getName() {
        return name;
    }

    public void setWinner() {
        this.winner = true;
    }

    public boolean isWinner() {
        return winner;
    }
}

class GameEngine {
    private final Scanner input = new Scanner(System.in);
    private final IMatchstickGame game;
    private final Player player1;
    private final Player player2;

    public GameEngine(IMatchstickGame game, Player player1, Player player2) {
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startGame() {
        System.out.println("\n\t\t* * * MATCHSTICK GAME * * *");

        Player currentPlayer = player1;
        int turn = 0;

        while (game.getMatchCount() > 0) {
            System.out.println(game);
            int taken = askForMove(currentPlayer);

            for (int i = 0; i < taken; i++) {
                game.removeLastMatch();
            }

            if (game.getMatchCount() == 0) {
                break;
            }

            currentPlayer = (turn++ % 2 == 0) ? player2 : player1;
        }

        Player winner = (currentPlayer == player1) ? player2 : player1;
        winner.setWinner();

        System.out.println("\nGAME OVER! WINNER: " + winner.getName() + " 🎉\n");
    }

    private int askForMove(Player player) {
        int taken;
        while (true) {
            System.out.print(player.getName() + ", take 1, 2, or 3 matches: ");
            while (!input.hasNextInt()) {
                System.out.print("Invalid input! Please enter a number: ");
                input.next();
            }
            taken = input.nextInt();

            if (taken >= 1 && taken <= 3 && taken <= game.getMatchCount()) {
                break;
            }
            System.out.println("Invalid move! Try again.");
        }
        return taken;
    }
}

class Main {
    private static final int MATCH_COUNT = 16;

    public static void main(String[] args) {
        IMatchstickGame game = new MatchstickGame(MATCH_COUNT);
        Player tom = new Player("Tom");
        Player anna = new Player("Anna");

        GameEngine engine = new GameEngine(game, tom, anna);
        engine.startGame();
    }
}
