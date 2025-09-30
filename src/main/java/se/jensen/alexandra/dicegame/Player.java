package se.jensen.alexandra.dicegame;

import java.util.Scanner;

public class Player {
    private String firstname;
    private String lastname;
    private int score;

    public Player() {
        this.firstname = "";
        this.lastname = "";
        this.score = 0;
    }

    public void setFirstname(Scanner scanner) {
        String firstName = scanner.nextLine();
        while (firstName == null || firstName.trim().isEmpty()) {
            System.out.println("You need to enter a first name, try again");
            firstName = scanner.nextLine();
        }
        this.firstname = firstName;
    }

    public void setLastname(Scanner scanner) {
        String lastName = scanner.nextLine();
        while (lastName == null || lastName.trim().isEmpty()) {
            System.out.println("You need to enter a last name, try again");
            lastName = scanner.nextLine();
        }
        this.lastname = lastName;
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        this.score = 0;
    }

    public String getFullName() {
        return firstname + " " + lastname;
    }

    public void addToScore(int newScore) {
        this.score += newScore;
    }
}
