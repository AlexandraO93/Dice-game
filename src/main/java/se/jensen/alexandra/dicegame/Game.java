package se.jensen.alexandra.dicegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<>(Arrays.asList(new Player(), new Player()));
    int numPlayers = players.size();
    int numDieThrow = 2;

    public void runTurn(int player) {
        Player currentPlayer = players.get(player);
        System.out.println(currentPlayer.getFullName() + " - Press enter, to throw the dice");
        scanner.nextLine();
        int score = Dice.roll();
        currentPlayer.addToScore(score);
        System.out.println("You got: " + score);
    }

    public void setupPlayer(int player) {
        Player currentPlayer = players.get(player);
        System.out.println("Player " + (player + 1) + "\n" +
                "Please, write your firstname");
        currentPlayer.setFirstname(scanner);
        System.out.println("Please, write your lastname");
        currentPlayer.setLastname(scanner);
    }

    public void gameLoop() {
        for (int player = 0; player < numPlayers; player++) {
            this.setupPlayer(player);
        }

        String choice = "";
        while (true) {
            System.out.println("Write play or quit");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("quit")) {
                this.quitGame();
                break;
            } else if (!choice.equalsIgnoreCase("play")) {
                System.out.println("Invalid choice, try again");
            } else {
                System.out.println("         Great! Lets play!");
                for (int turn = 0; turn < (numDieThrow * numPlayers); turn++) {
                    this.runTurn(turn % numPlayers);
                }
            }
            this.finalResults();
        }
    }

    public void quitGame() {
        scanner.close();
        System.out.println("Thanks for playing!");
    }

    public void finalResults() {
        Player playerOne = players.get(0);
        Player playerTwo = players.get(1);
        System.out.println(playerOne.getFullName() + " got: " + playerOne.getScore());
        System.out.println(playerTwo.getFullName() + " got: " + playerTwo.getScore());
        if (playerOne.getScore() > playerTwo.getScore()) {
            System.out.println(playerOne.getFullName() + ", you won!");
        } else if (playerTwo.getScore() > playerOne.getScore()) {
            System.out.println(playerTwo.getFullName() + ", you won!");
        } else {
            System.out.println("It's a tie");
        }
        playerOne.resetScore();
        playerTwo.resetScore();
    }
}
