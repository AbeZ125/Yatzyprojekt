import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Home on 2015-11-07.
 */
public class YatzyRules2 {

    public static HashMap<Integer, Player2> playerMap2 = new HashMap<>();
    public static ArrayList<Integer> scoreboard = new ArrayList<>();
    static Scanner keyboard = new Scanner(System.in);

    /*public void evaluatePoints(){

        for (int i=1; i<= playerMap.size(); i++) {
            //Gå igenom alla spelares hand och få fram int-värdet på varje tärning i handen.
            playerMap.get(i).getDicePoint();
            System.out.println("TESTING EVAL POINTS");
        }
    } */

    public static void playerSetup(int numOfPlayers) {
        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.printf("Enter your name, player %d: ", i);
            String playerName = keyboard.nextLine();
            playerMap2.put(i, new Player2(playerName));
            // scoreBoard.add(playerMap.get(i));
        }
    }

    public static void setScoreboard(int PlayerNr){

            System.out.println("WHAT");
            scoreboard.add(playerMap2.get(PlayerNr).evaluatePoints2(PlayerNr));
            System.out.println("TESTING THE SCOREBOARD");
            System.out.println(scoreboard);

    }




}
