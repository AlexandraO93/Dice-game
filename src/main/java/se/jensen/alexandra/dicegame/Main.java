package se.jensen.alexandra.dicegame;

public class Main {

    public static void main(String[] args) {
        //Info som visas direkt vid start av programmet
        System.out.println("\n" +
                "+------------------------------------------------------------+" + "\n" +
                "|                    Welcome to Dice Game!                   |" + "\n" +
                "|You throw two times, who ever gets the highest score - wins!|" + "\n" +
                "|                        Best of luck!                       |" + "\n" +
                "+------------------------------------------------------------+" + "\n");

        //Skapar objekt av Game klassen
        Game game = new Game();

        //Metod som startar spelet
        game.gameLoop();
    }
}
