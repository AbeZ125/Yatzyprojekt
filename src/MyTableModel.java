import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * A table model which shows {@link Player2} and Points.
 * MyTableModel will be updated to reflect changes observed in {@link GameModel}
 *
 * @author oscar
 * @version 1.0
 * @see Observer
 * @see AbstractTableModel
 * @see javax.swing.table.TableModel
 */
public class MyTableModel extends AbstractTableModel implements Observer {
    // Headers for the columns
   // String[] columnNames = {"Player", "Pair", "Two pair", "Triss" };


    /**
     * Gets the number of rows which will be equal to the number of Players
     * @return the number of players in the game model
     */
    @Override
    public int getRowCount() {
       return 15;

    }

    /**
     * Gets the number of columns which will be 2
     *
     * @return  the number of columns (2)
     */
    @Override
    public int getColumnCount() {
        GameModel model = GameModel.getInstance();
        return model.getPlayers().size()+2;

    }

    /**
     * Gets the heading for each column
     * @param column the column to set heading for
     * @return the heading for the column
     */
    @Override
    public String getColumnName(int column) {
        //return columnNames[column];
        if (column == 0) {
            return "Option";
        } else if (column == 1) {
            return "Points";
        }
        return Engine.playerMap2.get(column-1).getName();
    }

    /**
     * Sets all cells to not be editable
     * @param rowIndex      the row index for the cell
     * @param columnIndex   the column index for the cell
     * @return              false
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     * Gets the name or points for each {@link Player2} depending on the cell.
     * Each cell is mapped to values given by the {@link GameModel}.
     * Names are shown to the left ({@code columnIndex} is 0) while points are shown to the right.
     *
     * @param rowIndex      the row index for a cell
     * @param columnIndex   the column index for a cell
     * @return              the name or the points of a player
     */
   /* @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        GameModel model = GameModel.getInstance();
        ArrayList<Player2> players = model.getPlayers();

        // The index of the Player in the ArrayList is equal to the rowIndex for the Player in the JTable
        Player2 p = players.get(rowIndex);

        // Get name for the left column and points for the right column

        if(columnIndex == 0) {
            return p.getName();

        } else if (columnIndex == 1) {
            return p.upperTest[0];
          //  return p.getPoints();
        }

         else if (columnIndex == 2) {
        return p.SUPERTESTVECTOR[1];
        //  return p.getPoints();
         }

        else {
            return null;
        }
    }*/


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] option = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Sum", "Pair", "Two Pairs", "Three of a Kind",
                "Four of a Kind", "Small Ladder", "Big Ladder", "Full House", "Chance", "Yahzee"};
        int[] bla = {1,2,3,4,5,6};
        Player2 p = Engine.playerMap2.get(columnIndex-1);


         if (columnIndex == 0) {
            return option[rowIndex];

        }
         //Det går INTE att ta från en Player-array OM man inte hårdkodat tabellposition ELLER hårdkodat specifikt element i arrayen.

//Hämta godtyckligt element från "bla" som ligger innanför denna funktion går bra.
         else if (columnIndex== 1 && rowIndex<=5){
             System.out.println("VARFÖR");
             return bla[rowIndex];
         }
//Hårdkodad position i spelarens dummy-array går bra
       else  if(columnIndex==2) {
            return p.SUPERTESTVECTOR[0];
        }
//Hårdkodad position i tabellen gör att godtyckligt element i spelarens array går bra.
        else if(columnIndex==3&&rowIndex==3) {
            return p.SUPERTESTVECTOR[rowIndex-1];
        }

        else if(columnIndex==4) {
            return p.SUPERTESTVECTOR[2];
        }

        else if(columnIndex==5) {
            return p.SUPERTESTVECTOR[3];
        }

         else if(columnIndex==7) {
             for(int i=1; i<=5;i++) {
                 return p.SUPERTESTVECTOR[4];
             }
         }

            return null;

    }



    /**
     * Notifies the JTable using this model that data has changed.
     * This method is executed when the observed {@link GameModel} has changed.
     * The method <code>fireTableDataChanged()</code> is overriden from {@link AbstractTableModel}
     *
     * @see AbstractTableModel
     */
    @Override
    public void update(Observable o, Object arg) {
        fireTableDataChanged();
    }
}