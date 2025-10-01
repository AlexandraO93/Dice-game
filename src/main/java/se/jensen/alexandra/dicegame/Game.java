package se.jensen.alexandra.dicegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    //Variabler som behövs för spelet
    Scanner scanner = new Scanner(System.in);                                                   //Skapar nytt scanner objekt, återanvänds i Player klassen
    ArrayList<Player> players = new ArrayList<>(Arrays.asList(new Player(), new Player()));     //Skapar en lista av två Player objekt med tomma ingångsvärden, väljer ArrayList för att ev kunna ändra antalet spelare
    int numPlayers = players.size();                                                            //Returnerar antalet element i Arraylist (2 i detta fall) för antalet spelare. Det gör att jag lättare kan utöka antalet spelare
    int numDieThrow = 2;

    //Metod för en spelares runda
    public void runTurn(int player) {
        Player currentPlayer = players.get(player);                                             //Från ArrayList plockar den 0 eller 1 (eftersom det är två spelare) och vet så vems tur det är
        System.out.println("\n" + currentPlayer.getFullName() + " - Press enter, to throw the dice"); //getFullName() plockas från Player via den publika metoden i klassen.
        scanner.nextLine();                                                                     //Inväntar att användaren trycker Enter, för att göra ett aktivt val att slå
        int score = Dice.roll();                                                                //Tärningen kastas via metoden från Dice, värdet sparas i score variabeln
        Dice.printDice(score);                                                                  //En ASCII bild visas av en tärning via metoden i Dice klassen
        currentPlayer.addToScore(score);                                                        //Värdet sparas också till spelarens totala poäng
        System.out.println("You got: " + score);                                                //Rundans resultat skrivs ut
    }

    //Inmatning och registrering av namn till spelare 1 och 2
    public void setupPlayer(int player) {
        Player currentPlayer = players.get(player);                                             //Funkar på samma sätt som rad 16, hämtar 0 eller 1 från ArrayList
        System.out.println("********* Player " + (player + 1) + " *********" + "\n" +           //player +1 då spelare 1 har index 0
                "Please, write your firstname");
        currentPlayer.setFirstname(scanner);                                                    //Sparar inmatade värdet i scanner till currentPlayer via metoden setFirstname som kontrollerar att det ej är tomt
        System.out.println("Please, write your lastname");
        currentPlayer.setLastname(scanner);
    }

    //Loop för att starta spelet, spelet körs
    public void gameLoop() {                                                                    //Metoden startar spelet och anropas från Main
        for (int player = 0; player < numPlayers; player++) {                                   //Plockar antalet spelare via rad 11 numPlayers
            this.setupPlayer(player);                                                           //Antalet som registreras via loopen sparas i variabeln setupPlayer
        }

        String choice = "";                                                                     //Skapar choice som en variabel - här sätts värdet play eller quit in
        while (true) {                                                                          //Satt till true för att loopen ska fortsätta köras tills vi väljer att avsluta
            System.out.println("\n" + "Write play or quit");
            choice = scanner.nextLine();                                                        //sparar inmatat värde från scanner till choice
            if (choice.equalsIgnoreCase("quit")) {                                  //equalsIgnoreCase gör att systemet inte ska låsa sig i quit eller Quit - båda inmatningar ok
                this.quitGame();                                                                //om inmatning quit - metoden quitGame avslutar spelet
                break;                                                                          //då avslutas loopen och spelet stängs av
            } else if (!choice.equalsIgnoreCase("play")) {                          //om annat än play - felaktigt val och loopen fortsätter fråga om val
                System.out.println("Invalid choice, try again");
            } else {
                System.out.println("\n" + "********** Great! Lets play! **********");
                for (int turn = 0; turn < (numDieThrow * numPlayers); turn++) {                 //loop som kör antalet satta kast * antalet satta spelare (här 4 varv)
                    this.runTurn(turn % numPlayers);                                     //metoden körs enligt modulo-operator som matematiskt (resten vid division) räknar ut 0/1/0/1 och på så sätt tar fram vilken spelares tur det är
                }
                this.finalResults();                                                            //efter alla rundor anropas metoden som visar slutresultat
            }

        }
    }

    //Avsluta spelet
    public void quitGame() {
        scanner.close();
        System.out.println("""
                
                Thanks for playing!
                     Goodbye!""");
    }

    //Utskrift av slutresultat
    public void finalResults() {
        Player playerOne = players.get(0);                                                             //Skapar variabler av de två spelarna, index 0 och 1
        Player playerTwo = players.get(1);                                                             //playerOne är kortare än att skriva ut players.get(0) hela tiden. Ger snyggare kod
        System.out.println("""
                
                ***************************************************
                And the final result is:
                """);
        System.out.println(playerOne.getFullName() + " got: " + playerOne.getScore());                 //Hämtar och konkatenerar sparat fullständigt namn och sparat score från Player objektet
        System.out.println(playerTwo.getFullName() + " got: " + playerTwo.getScore());
        if (playerOne.getScore() > playerTwo.getScore()) {                                             //Jämför högst poäng, skriver ut vem som vann eller ev oavgjort
            System.out.println(playerOne.getFullName() + ", you won! Congratulations!" + "\n" +
                    "***************************************************");
        } else if (playerTwo.getScore() > playerOne.getScore()) {
            System.out.println(playerTwo.getFullName() + ", you won! Congratulations!" + "\n" +
                    "***************************************************");
        } else {
            System.out.println("It's a tie" + "\n" +
                    "***************************************************");
        }
        //Återställer score inför nästa spelomgång
        playerOne.resetScore();
        playerTwo.resetScore();
    }
}
