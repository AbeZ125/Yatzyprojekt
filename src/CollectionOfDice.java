import java.util.ArrayList;
import java.util.Random;


public class CollectionOfDice {

    public static ArrayList<Dice> pileOfDice = new ArrayList<Dice>();
    static Random rand = new Random();
    static int randomDiceValue;


//Skapar en array med fem tärningar i sig, tärningarna har randomvärden. Läggs i hög med tärningar.
    public static ArrayList<Dice> generateDice(int playerAmount) {



        for (int i = 1; i <= 5*playerAmount; i++) {
            //Random rand = new Random();
            //int randomDiceValue = rand.nextInt((6 - 1) + 1) + 1;
           // Dice dice = new Dice(randomDiceValue);
            Dice dice = new Dice();
            pileOfDice.add(dice);
             //System.out.println(dice);
        }

        return pileOfDice;

    }
//Ska skicka iväg en tärning (metod som spelare ska anropa). //TOG BORT (int dicenr) SOM PARAMETER.
    public static Dice sendAwayDice(int dicenr) {

      //  randomDiceValue = rand.nextInt((6 - 1) + 1) + 1;

      //  Dice diceToBeSent = pileOfDice.get(dicenr);
      //  pileOfDice.remove(dicenr);

        //Dice diceToBeSent = new Dice(randomDiceValue);
       Dice diceToBeSent = new Dice();
        return diceToBeSent;
    }
}
