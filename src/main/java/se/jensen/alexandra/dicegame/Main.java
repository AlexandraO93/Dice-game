package se.jensen.alexandra.dicegame;

public class Main {

    public static void main(String[] args) {
        System.out.println("            Welcome to Dice Game!");
        System.out.println("You throw two times, who ever gets the highest score - wins!");
        System.out.println("               Best of luck!");
        System.out.println();
        Game game = new Game();
        game.gameLoop();
    }
}
