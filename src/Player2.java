import java.util.ArrayList;
import java.util.Scanner;

public class Player2 {

    public ArrayList<Dice> handOfDice = new ArrayList<>();
    public ArrayList<Integer> playerTempScore = new ArrayList<>();
    public ArrayList<Integer> scoreCard = new ArrayList<>();

    Scanner keyboard = new Scanner(System.in);
    String name ="";
    int retry = 3;

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

    public void reRollDice(){

        //MASSA KOD!!!!!!!!!!!!!!!!
    }

    public String toString() { // ALLTID MED (mer eller mindre standard f?r objekt).
        return " the player now has BLALBA";
    }



    public int evaluatePoints2(int playernr){
        int pointSum = 0;
        for (int i=0; i < handOfDice.size(); i++) {
            //Gå igenom spelares hand och få fram int-värdet på varje tärning i handen.
            int pScore = handOfDice.get(i).getDiceValue();
            playerTempScore.add(pScore);


            for (int j: playerTempScore){
                pointSum = pointSum + j;
            }

            System.out.println("Player " + playernr + " has: " + pointSum);
        }
        scoreCard.add(pointSum);
        return pointSum;

    }
}
