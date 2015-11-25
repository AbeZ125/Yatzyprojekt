import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
    // Swing grafik
    JPanel mainPanel, dicePanel, buttonPanel;
    JButton rollButton;
    JButton checkButton;
    JRadioButton radio1, radio2, radio3, radio4, radio5;
    JTable table;

    // Model f�r t�rning
    Dice dice1, dice2, dice3, dice4, dice5;

    // View f�r t�rning
    DiceImage diceImage1, diceImage2, diceImage3, diceImage4, diceImage5;


    GUI() {
        createAndShowGui();
    }

    public void createAndShowGui() {
        // Den yttersta panelen
        mainPanel = new JPanel();

        // Grafik
        dicePanel = new JPanel();
        buttonPanel = new JPanel();
        table  = new JTable(5,Engine.playerSize);

        radio1 = new JRadioButton();
        radio2 = new JRadioButton();
        radio3 = new JRadioButton();
        radio4 = new JRadioButton();
        radio5 = new JRadioButton();

        // Initiera Model f�r t�rningar
        dice1 = Engine.handOfDice.get(0);
        dice2 = Engine.handOfDice.get(1);
        dice3 = Engine.handOfDice.get(2);
        dice4 = Engine.handOfDice.get(3);
        dice5 = Engine.handOfDice.get(4);


        // Initiera View f�r t�rningar
        diceImage1 = new DiceImage();
        diceImage1.addMouseListener(new Mouse());

        diceImage2 = new DiceImage();
        diceImage2.addMouseListener(new Mouse());

        diceImage3 = new DiceImage();
        diceImage3.addMouseListener(new Mouse());

        diceImage4 = new DiceImage();
        diceImage4.addMouseListener(new Mouse());

        diceImage5 = new DiceImage();
        diceImage5.addMouseListener(new Mouse());
        // L�gg till en DiceImage som observat�r p� en Dice
        // L�gg till t�rningsbild som en observat�r p� en t�rning
        dice1.addObserver(diceImage1);
        dice2.addObserver(diceImage2);
        dice3.addObserver(diceImage3);
        dice4.addObserver(diceImage4);
        dice5.addObserver(diceImage5);


        // Knappen "Roll dice!" och vad som ska h�nda n�r man klickar p� den
        rollButton = new JButton("Roll dice!");
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vad som ska ske n�r man klickar p� "Roll dice!"
                dice1.roll();
                dice2.roll();
                dice3.roll();
                dice4.roll();
                dice5.roll();
            }
        });

        checkButton = new JButton("Check!");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.evaluatePoints2();
                Engine.houseCheck();
                Engine.straightCheck();
                Engine.fiveOfAKind();
                Engine.onesSixCheck();
                Engine.switchPlayer();

            }
        });

        radio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.playerMap2.get(Engine.baton).gatherUpperPoints(Engine.handOfDice.get(0).getDiceValue());
            }
        });

        radio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.playerMap2.get(Engine.baton).gatherUpperPoints(Engine.handOfDice.get(1).getDiceValue());
            }
        });

        radio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.playerMap2.get(Engine.baton).gatherUpperPoints(Engine.handOfDice.get(2).getDiceValue());
            }
        });

        radio4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.playerMap2.get(Engine.baton).gatherUpperPoints(Engine.handOfDice.get(3).getDiceValue());
            }
        });

        radio5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.playerMap2.get(Engine.baton).gatherUpperPoints(Engine.handOfDice.get(4).getDiceValue());
            }
        });

        // L�gg till t�rningsbilder i panel
        dicePanel.add(diceImage1);
        dicePanel.add(diceImage2);
        dicePanel.add(diceImage3);
        dicePanel.add(diceImage4);
        dicePanel.add(diceImage5);

        dicePanel.add(radio1);
        dicePanel.add(radio2);
        dicePanel.add(radio3);
        dicePanel.add(radio4);
        dicePanel.add(radio5);

        // L�gg till knappen i en panel
        buttonPanel.add(rollButton);
        buttonPanel.add(checkButton);

        // L�gg till paneler i yttre panel
        mainPanel.add(dicePanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(table);

        add(mainPanel);

        pack();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class Mouse extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            DiceImage i = (DiceImage) e.getSource();
            if (i == diceImage1) {
                Engine.useLock(0);

            }

            else if (i == diceImage2) {
                Engine.useLock(1);
            }

            else if (i == diceImage3) {
                Engine.useLock(2);
            }
            else if (i == diceImage4) {
                Engine.useLock(3);
            }
            else if (i == diceImage5) {
                Engine.useLock(4);
            }
        }
    }

}


