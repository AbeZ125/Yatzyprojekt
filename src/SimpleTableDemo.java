

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * SimpleTableDemo.java modified so that JTable uses MyTableModel which mirrors GameModel.
 * Original is <a href="https://docs.oracle.com/javase/tutorial/uiswing/examples/components/SimpleTableDemoProject/src/components/SimpleTableDemo.java">SimpleTableDemo.java</a> from the official Java tutorials.
 *
 * For further documentation, see <a href="http://docs.oracle.com/javase/tutorial/uiswing/components/table.html">Creating a Table Model</a> in The Java Tutorial.
 */
public class SimpleTableDemo extends JPanel {

    JTable table;

    /**
     * Initiates a JPanel with JTable while adding observers and listeners
     */
    public SimpleTableDemo() {
        // To maximize the width and height of the JTable to the size of the JPanel,
        // use GridLayout
        setLayout(new GridLayout(1, 0));

        // Initiate the custom table model, MyTableModel
        MyTableModel myTableModel = new MyTableModel();

        // myTableModel will be observing (the instance of) GameModel
        GameModel.getInstance().addObserver(myTableModel);

        table = new JTable(myTableModel);

        // Add listener for mouse clicks on the JTable
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                // Get which row the user clicked
                int rowClicked = table.rowAtPoint(e.getPoint());

                // Add 10 points to the player who's row was clicked
                GameModel.getInstance().addPoints(rowClicked, 10);
            }
        });

        // Set size of JTable
        table.setPreferredScrollableViewportSize(new Dimension(500, 150));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    /**
     * Creates the GUI with the JTable and shows it.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo - Modified by Oscar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        SimpleTableDemo newContentPane = new SimpleTableDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Sets up the Game Model with Players and points for each Player.
     */
    public static void setUpModel () {
        GameModel model = GameModel.getInstance();
        for(int i=1; i<=Engine.playerMap2.size(); i++){
            model.addPlayer(Engine.playerMap2.get(i));
        }
    }

    /**
     *  The entry-point, sets up the Game Model and the GUI.
     *  The program starts here.
     */
    /*public static void main(String[] args) {
        setUpModel();
        createAndShowGUI();
    } */

}