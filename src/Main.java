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
        YatzyRules.playerSetup(nrOfPlayers);
        //Player abe = new Player("abe");
        //abe.getMyDice();
        CollectionOfDice.generateDice(nrOfPlayers);
        for(int i=1; i <= nrOfPlayers; i++){
            YatzyRules.playerMap.get(i).getDice();
            YatzyRules.playerMap.get(i).evaluatePoints(i);
            YatzyRules.playerMap.get(i).discardDice(0);
            YatzyRules2.setScoreboard(1);
        }
        //abe.getDice();
        //abe.getSomeNewDice(3);
       // abe.discardDice(0);

    }
}
