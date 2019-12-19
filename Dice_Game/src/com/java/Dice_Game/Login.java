package com.java.Dice_Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener
{
    private int numberOfLapsForTheGame = 0;

    final private JLabel title = new JLabel("Willkommen im Spiel, bitte die uneten aufgelisteten Felder ausfüllen");
    final private JLabel playerOneName = new JLabel("Player Nr. 1: ");
    final private JLabel playerTwoName = new JLabel("Player Nr. 2: ");
    final private JLabel numberOfLaps = new JLabel("number of laps 1-5: ");

    private JTextField playerOneTextField = new JTextField();
    private JTextField playerTwoTextField = new JTextField();
    private JTextField numberOfLapsTextField = new JTextField();

    private JButton startButton = new JButton("Start the game");

    Player playerOne = new Player("", 0, 0, true, true);
    Player playerTwo = new Player("", 0, 0, true, true);

    public void login()
    {
        setLayout(null);

        title.setBounds(5, 10, 500, 20);
        numberOfLaps.setBounds(60, 180, 150, 20);
        playerOneName.setBounds(60, 60, 150, 20);
        playerTwoName.setBounds(60, 120, 150, 20);
        playerOneTextField.setBounds(180, 61, 150, 20);
        playerTwoTextField.setBounds(180, 121, 150, 20);
        numberOfLapsTextField.setBounds(180, 181, 150, 20);

        add(title);
        add(numberOfLaps);
        add(playerOneName);
        add(playerTwoName);
        add(playerOneTextField);
        add(playerTwoTextField);
        add(numberOfLapsTextField);

        startButton.setBounds(180, 220, 150, 20);
        add(startButton);
        startButton.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Dice Game login");
        setSize(500, 300);
        setLocation(750, 350);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent givenInstruction)
    {
        if (givenInstruction.getSource() == startButton)
        {
            String tempLaps = numberOfLapsTextField.getText();
            int laps = Integer.parseInt(tempLaps);

            playerOne.setName(playerOneTextField.getText());
            playerTwo.setName(playerTwoTextField.getText());

            Game game = new Game(playerOne, playerTwo, laps);
            game.start();

            dispose();
        }
    }
}
