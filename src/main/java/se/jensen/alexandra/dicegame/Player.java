package se.jensen.alexandra.dicegame;

import java.util.Scanner;

public class Player {                       //Skapar klassen Player med attributen firstname, lastname och score
    private String firstname;
    private String lastname;
    private int score;

    //Konstruktor
    public Player() {                   //Konstruktor med samtliga attribut satta till noll eller tom sträng,
        this.firstname = "";            //konstruktor är skapad för att kunna skapa Player objekt i övriga klasser som behöver
        this.lastname = "";             //kunna plocka upp metoder/attribut från Player klassen
        this.score = 0;
    }

    //Setters
    public void setFirstname(Scanner scanner) {                    //Används för att sätta användarnamnet i Game klassen
        String firstName = scanner.nextLine();                     //värdet sätts via input från scanner och sparas i variabeln firstname
        while (firstName == null || firstName.trim().isEmpty()) {  //värdet kontrolleras så det inte är tomt eller null, där trim() tar bort mellanslag och kontrollerar sedan mot .isEmpty()
            System.out.println("You need to enter a first name, try again");
            firstName = scanner.nextLine();                        //felmeddelande skrivs ut, och användaren får ny chans att skriva
        }
        this.firstname = firstName;                               //om värde finns, uppdateras variabeln firstname till inmatat värde
    }

    public void setLastname(Scanner scanner) {                    //upplagd på samma sätt som setFirstname
        String lastName = scanner.nextLine();
        while (lastName == null || lastName.trim().isEmpty()) {
            System.out.println("You need to enter a last name, try again");
            lastName = scanner.nextLine();
        }
        this.lastname = lastName;
    }

    //Getters
    public int getScore() {                                     //Används för att hämta sparat score värde för en spelare
        return score;
    }

    public String getFullName() {                             //En metod som konkatinerar inmatade värden av first och lastname
        return firstname + " " + lastname;                    //för att snabbt kunna skriva ut fullt namn
    }

    //Nollställ score
    public void resetScore() {                                 //När en spelomgång är avslutad återställs score värdet till 0
        this.score = 0;                                        //för att kunna spela igen med samma spelare men nya tärningskast
    }

    //Lagrar och adderar värdet av tärningskasten
    public void addToScore(int newScore) {                      //Efter varje runda ska tärningsslagets summa sparas i score
        this.score += newScore;                                 //för att kunna summera vad båda tärningskasten ger.
    }
}
