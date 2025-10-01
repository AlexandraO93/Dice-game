package se.jensen.alexandra.dicegame;

public class Main {

    public static void main(String[] args) {
        //Info som visas direkt vid start av programmet
        System.out.println("""
                
                +------------------------------------------------------------+
                |                    Welcome to Dice Game!                   |
                |You throw two times, who ever gets the highest score - wins!|
                |                        Best of luck!                       |
                +------------------------------------------------------------+
                """);

        //Skapar objekt av Game klassen
        Game game = new Game();

        //Metod som startar spelet
        game.gameLoop();
    }
}
