import java.util.Scanner;

/**
 * Created by Home on 2015-11-07.
 */
public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static int nrOfPlayers;
    public static void main (String []args){
       // CollectionOfDice.generateDice();
        System.out.println("How many players?");
        nrOfPlayers = keyboard.nextInt();
        YatzyRules2.playerSetup(nrOfPlayers);

        CollectionOfDice.generateDice(nrOfPlayers);
        for(int i=1; i <= nrOfPlayers; i++){
            YatzyRules2.playerMap2.get(i).getDice();
          //  YatzyRules2.playerMap2.get(i).discardDice(0);
            YatzyRules2.playerMap2.get(i).lockandRoll();
           // YatzyRules2.playerMap2.get(i).evaluatePoints2();
          //  YatzyRules2.setScoreboard(i);
        }


    }
}
