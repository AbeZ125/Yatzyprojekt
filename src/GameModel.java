import java.util.ArrayList;
import java.util.Observable;

/**
 * The GameModel is a simple game model keeping track of player names and points.
 * It's observed by {@link MyTableModel}
 * For easy access to the game model, it uses the design pattern <strong>Singleton</strong>
 *
 * @author oscar
 * @version 1.0
 * @see Observable
 */
public class GameModel extends Observable {
    // Set up Singleton use
    private static GameModel theInstance = null;

    // Keep track of players
    private ArrayList<Player2> players;

    /**
     * Private constructor to only allow one instance created from this class
     */
    private GameModel() {
        players = new ArrayList<>();
    }

    /**
     * If no GameModel has been created, create and return one.
     * Only one instance of GameModel is allowed.
     * All references to this object should be made using <code>GameModel.getInstance()</code>
     *
     * @return the one and single instance
     */
    public static GameModel getInstance() {
        if(theInstance == null) {
            theInstance = new GameModel();
        }
        return theInstance;
    }

    /**
     * Adds {@code points} to a Player in the ArrayList chosen by {@code playerIndex}
     *
     * @param playerIndex   the index of the player in the ArrayList
     * @param points        the amount of points to add to the player
     */
    public void addPoints(int playerIndex, int points) {
        players.get(playerIndex).addPoints(points);

        // Notify everyone observing me!
        setChanged();
        notifyObservers();
    }

    /**
     * Adds a {@link Player2} to a list of players in the game model
     *
     * @param player the player to be added
     * @see Player2
     */
    public void addPlayer(Player2 player) {
        players.add(player);
    }

    /**
     * Gets all the players as an ArrayList
     * @return  the ArrayList of players
     */
    public ArrayList<Player2> getPlayers() {
        return players;
    }

}