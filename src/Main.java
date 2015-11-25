import java.util.Scanner;

/**
 * Created by Home on 2015-11-07.
 */
public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static int nrOfPlayers;
    public static void main (String []args){
       // CollectionOfDice.generateDice();
        Engine.getDice();
        GUI yatzyGUI = new GUI();



        System.out.println("How many players?");
        nrOfPlayers = keyboard.nextInt();
        Engine.playerSetup(nrOfPlayers);


        //NYTT-------------------------------
        SimpleTableDemo.setUpModel();
        SimpleTableDemo.createAndShowGUI();

        /*-----------------------------------*/
      //  CollectionOfDice.generateDice(nrOfPlayers);
        for(int i=1; i <= nrOfPlayers; i++){
         //   Engine.getDice();
           // Engine.useLock(1);
         //   Engine.lockandRoll();
          //  YatzyRules2.playerMap2.get(i).discardDice(0);
           // YatzyRules2.playerMap2.get(i).lockandRoll();
           // YatzyRules2.playerMap2.get(i).reRollRound();
            Engine.evaluatePoints2();
          //  YatzyRules2.setScoreboard(i);


        }


    }
}
