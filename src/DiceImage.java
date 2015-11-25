import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by oscar on 2015-11-16.
 */
public class DiceImage extends JLabel implements Observer {
    // En referens till bilderna på datorn för varje ikon, dessa rader kan behöva ändras
    static ImageIcon icon1 = new ImageIcon(DiceImage.class.getResource("dice1.png"));
    static ImageIcon icon2 = new ImageIcon(DiceImage.class.getResource("dice2.png"));
    static ImageIcon icon3 = new ImageIcon(DiceImage.class.getResource("dice3.png"));
    static ImageIcon icon4 = new ImageIcon(DiceImage.class.getResource("dice4.png"));
    static ImageIcon icon5 = new ImageIcon(DiceImage.class.getResource("dice5.png"));
    static ImageIcon icon6 = new ImageIcon(DiceImage.class.getResource("dice6.png"));

    // Samla alla ikoner i en array för lättare åtkomst
    static ImageIcon[] icons = {icon1, icon2, icon3, icon4, icon5, icon6};

    public DiceImage() {
        setIcon(icons[0]); // Sätt bild till tärning 1 som standard
    }

    // Skriv en metod som tar emot ett tal och byter ut till bild på tärning för det talet
    public void changeImage (int diceValue) {
        if(diceValue >= 1 && diceValue <= 6) {
            setIcon(icons[diceValue-1]);
        }

        // Vad göra om talet inte är mellan 1 och 6?
    }

    // Eftersom vi implementerar Observer måste vi ha metoden update();
    @Override
    public void update(Observable o, Object arg) {
        // Hämta den observerade tärningen
        Dice theObservedDice = (Dice) o;
        int theObservedDiceValue = theObservedDice.getDiceValue();

        // Ändra bild baserat på observerad tärning
        changeImage(theObservedDiceValue);

        // Gör ovan med en rad istället
        // int result = ((Dice)o).getValue();

    }
}
