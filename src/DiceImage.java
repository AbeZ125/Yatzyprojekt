import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by oscar on 2015-11-16.
 */
public class DiceImage extends JLabel implements Observer {
    // En referens till bilderna p� datorn f�r varje ikon, dessa rader kan beh�va �ndras
    static ImageIcon icon1 = new ImageIcon(DiceImage.class.getResource("dice1.png"));
    static ImageIcon icon2 = new ImageIcon(DiceImage.class.getResource("dice2.png"));
    static ImageIcon icon3 = new ImageIcon(DiceImage.class.getResource("dice3.png"));
    static ImageIcon icon4 = new ImageIcon(DiceImage.class.getResource("dice4.png"));
    static ImageIcon icon5 = new ImageIcon(DiceImage.class.getResource("dice5.png"));
    static ImageIcon icon6 = new ImageIcon(DiceImage.class.getResource("dice6.png"));

    // Samla alla ikoner i en array f�r l�ttare �tkomst
    static ImageIcon[] icons = {icon1, icon2, icon3, icon4, icon5, icon6};

    public DiceImage() {
        setIcon(icons[0]); // S�tt bild till t�rning 1 som standard
    }

    // Skriv en metod som tar emot ett tal och byter ut till bild p� t�rning f�r det talet
    public void changeImage (int diceValue) {
        if(diceValue >= 1 && diceValue <= 6) {
            setIcon(icons[diceValue-1]);
        }

        // Vad g�ra om talet inte �r mellan 1 och 6?
    }

    // Eftersom vi implementerar Observer m�ste vi ha metoden update();
    @Override
    public void update(Observable o, Object arg) {
        // H�mta den observerade t�rningen
        Dice theObservedDice = (Dice) o;
        int theObservedDiceValue = theObservedDice.getDiceValue();

        // �ndra bild baserat p� observerad t�rning
        changeImage(theObservedDiceValue);

        // G�r ovan med en rad ist�llet
        // int result = ((Dice)o).getValue();

    }
}
