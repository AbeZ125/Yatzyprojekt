import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Home on 2015-11-07.
 */
public class YatzyRules {

    public static HashMap<Integer, Player> playerMap = new HashMap<>();

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
            playerMap.put(i, new Player(playerName));
           // scoreBoard.add(playerMap.get(i));
        }
    }


}
