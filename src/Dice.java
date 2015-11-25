import java.util.Observable;
import java.util.Random;

public class Dice extends Observable implements Comparable {

    static Random rand = new Random();
    static int randomDiceValue;
    public int digit;
    public boolean locked=false;

    public Dice(){

         //   randomDiceValue = rand.nextInt((6 - 1) + 1) + 1;
          //  digit = randomDiceValue;
            roll();
    }


    public String toString(){
        return "Dice value is: " + digit;
    }



    public void roll(){

        if(locked==false){

            randomDiceValue = rand.nextInt((6 - 1) + 1) + 1;
            digit = randomDiceValue;
            //GUI-RELATERAT.
            setChanged();
            notifyObservers();
        }
        else{
            System.out.println("-");

        }

    }

    public int getDiceValue(){
        return digit;
    }

    public boolean setDiceLock(){
        if(locked==false) {
            locked = true;
            System.out.println("Dice locked!");
            System.out.println(locked);
        }

        else if(locked==true){
            locked = false;
            System.out.println("Dice unlocked!");
            System.out.println(locked);

        }
        return locked;
    }

    public static void lockADie(int dieNrToBeLocked){
        Engine.handOfDice.get(dieNrToBeLocked).setDiceLock();
       // System.out.println("locked die nr " + dieNrToBeLocked);
    }

    public void unlockAll(){
        locked=false;
    }


    @Override
    public int compareTo(Object o) {
        Dice otherDice = (Dice) o;
        if(this.getDiceValue()>otherDice.getDiceValue()){
            return -1;
        }
       else if(this.getDiceValue()==otherDice.getDiceValue()){
            return 0;
        }

        else if(this.getDiceValue()<otherDice.getDiceValue()){
            return -1;
        }
        return 0;
    }
}
