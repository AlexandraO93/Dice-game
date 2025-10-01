package se.jensen.alexandra.dicegame;

import java.util.Random;

public class Dice {                                  //Klassen Dice skapas för att kunna skapa en metod roll
    static Random random = new Random();             //denna simulerar ett tärningskast som med hjälp av random instansen
    //kastar ett random tal mellan 1 och 6 (vi skriver 7 då vi vill ha en siffra fram till 7)

    public static int roll() {                      //Själv metoden som skapar ett random tärningskast och returnerar det värdet
        return random.nextInt(1, 7);    //tillbaka till där man anropade metoden
    }                                               //jag använder static då alla tärningskast använder samma randomgenerator då jag slipper skapa dice-objekt

    public static void printDice(int number) {
        switch (number) {
            case 1:
                System.out.println("\n" +
                        "+-----+" + "\n" +
                        "|     |" + "\n" +
                        "|  *  |" + "\n" +
                        "|     |" + "\n" +
                        "+-----+");
                break;
            case 2:
                System.out.println("\n" +
                        "+-----+" + "\n" +
                        "| *   |" + "\n" +
                        "|     |" + "\n" +
                        "|   * |" + "\n" +
                        "+-----+");
                break;
            case 3:
                System.out.println("\n" +
                        "+-----+" + "\n" +
                        "| *   |" + "\n" +
                        "|  *  |" + "\n" +
                        "|   * |" + "\n" +
                        "+-----+");
                break;
            case 4:
                System.out.println("\n" +
                        "+-----+" + "\n" +
                        "| * * |" + "\n" +
                        "|     |" + "\n" +
                        "| * * |" + "\n" +
                        "+-----+");
                break;
            case 5:
                System.out.println("\n" +
                        "+-----+" + "\n" +
                        "| * * |" + "\n" +
                        "|  *  |" + "\n" +
                        "| * * |" + "\n" +
                        "+-----+");
                break;
            case 6:
                System.out.println("\n" +
                        "+-----+" + "\n" +
                        "| * * |" + "\n" +
                        "| * * |" + "\n" +
                        "| * * |" + "\n" +
                        "+-----+");
                break;
            default:
                System.out.println("Ogiltigt kast");
        }
    }
}
