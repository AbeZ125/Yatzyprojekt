import java.util.Random;

public class Dice {

    static Random rand = new Random();
    static int randomDiceValue;
    public int digit;

    public Dice(){
        randomDiceValue = rand.nextInt((6 - 1) + 1) + 1;
        digit=randomDiceValue;
    }

    /*public Dice(int digit){
    this.digit = digit;
    } */

    public String toString(){
        return "Dice value is: " + digit;
    }

    public int getDiceValue(){
        return digit;
    }
}
