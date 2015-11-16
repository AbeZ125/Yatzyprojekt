import java.util.ArrayList;
import java.util.Scanner;

public class Player2 {

    public ArrayList<Dice> handOfDice = new ArrayList<>();
    public ArrayList<Dice> temporaryDiceList = new ArrayList<>();
    public ArrayList<Integer> playerTempScore = new ArrayList<>();
    public ArrayList<Integer> scoreCard = new ArrayList<>();

    Scanner keyboard = new Scanner(System.in);
    String name ="";
    int retry = 3;
    int diceNrToThrow;
    boolean lock;

    public Player2(String name){
        this.name=name;
    }

    /*public void getMyDice() {
        System.out.println(name + " gets 5 dice with...");
      //CollectionOfDice.generateDice();
    } */

    public void getDice() {
        System.out.println("So you want some dice, eh?");
        for(int i=1; i <= 5; i++) {
            Dice diceChosen = CollectionOfDice.sendAwayDice(i);
            handOfDice.add(diceChosen);
        }
        System.out.println(handOfDice);
    }

    public void getSomeNewDice(int diceYouWant) {
        System.out.println("So you want some new dice, eh?");
        Dice diceChosen = CollectionOfDice.sendAwayDice(diceYouWant);
        handOfDice.add(diceChosen);
        System.out.println(handOfDice);

    }

    public void discardDice(int diceNrToThrow){
        if(retry!=0) {
            System.out.println("Throwing dice nr " + diceNrToThrow);
            handOfDice.remove(diceNrToThrow);
            System.out.println("here's your new one.");

            getSomeNewDice(0);
            System.out.println("Satisfied? You've only got " + retry + " tries left.");

            String wantToReroll=keyboard.nextLine();
            if(wantToReroll.equals("no")) {
                retry--;
                discardDice(diceNrToThrow);

            }
        }
        else {
            System.out.println("Sorry, you've rerolled enough.");
            retry=3;
        }
    }

    public void reroll(int diceNrToThrow){
        //VILKA TÄRNINGAR VILL DU RULLA OM?

            this.diceNrToThrow = diceNrToThrow;
        if(lock==false) {

            System.out.println("Throwing dice nr " + diceNrToThrow);
            handOfDice.remove(diceNrToThrow);
            System.out.println("here's your new one.");
            getSomeNewDice(0);
        }

        else{
            System.out.println(diceNrToThrow + " is locked, sorry.");
        }

    }


    public void lockADie(int dieNrToBeLocked){
        lock=handOfDice.get(dieNrToBeLocked).setDiceLock();
        System.out.println("locked die nr " + dieNrToBeLocked);
    }

    public void reRollRound(){


        while(retry!=0) {
    System.out.println("Inne i rerollround");
            for (int i = 1; i <= 4; i++) {

                System.out.println("Reroll dice nr " + i + "?");
                String throwDie = keyboard.nextLine();
                if(throwDie.equals("yes")) {
                    reroll(i);
                    System.out.println("Rerolled dice nr "+ i +".");
                }

            }
            retry--;
            System.out.println("You have " + retry + " tries left.");
        }


            System.out.println("Sorry, you're out of retries.");

    }

    public void lockandRoll(){

        lockADie(2);
        while(retry!=0) {
            System.out.println("Inne i lockandROLL");
            for (int i = 1; i <= 4; i++) {
                    reroll(i);
            }
            retry--;

        }



        System.out.println("Sorry, you're out of retries.");

    }
    public String toString() { // ALLTID MED (mer eller mindre standard f?r objekt).
       // return " the player now has BLALBA";
        return name;
    }



    public ArrayList<Integer> evaluatePoints2(){
       int pointSum=0;
        int pointComparison=0;

        for (int i=0; i < handOfDice.size(); i++) {
            //Gå igenom spelares hand och få fram int-värdet på varje tärning i handen.

            pointComparison = handOfDice.get(i).getDiceValue();
            for(int j=1; j < i; j++) {
                if (pointComparison == handOfDice.get(j).getDiceValue()) {
                    System.out.println("You've got a pair!");
                    System.out.println(pointComparison + "* 2 = " + pointComparison*2);
                }
            }
            pointSum += handOfDice.get(i).getDiceValue();

            /*  //Kollar om två är identiska! FUNKAR EJ.
                for (int j=0; j < i; j++){
                    if(handOfDice.get(i).getDiceValue() == handOfDice.get(i+j).getDiceValue());{
                        pointSum = handOfDice.get(i).getDiceValue() + handOfDice.get(i+j).getDiceValue();
                        System.out.println("YO I'M ADDING DA PAIRS");
                    }
                }*/
        }
        scoreCard.add(pointSum);
        System.out.println("Player " + name + " has: " + pointSum);
        return scoreCard;


    }
}
