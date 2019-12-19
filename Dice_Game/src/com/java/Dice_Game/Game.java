package com.java.Dice_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener
{
    private Player m_PlayerOne;
    private Player m_PlayerTwo;

    //TODO: Player panels

    private int m_Laps;
    final boolean m_IsVisible = true;
    final boolean m_CanRoll = true;
    final boolean m_CanSetPanel = true;

    public Game(Player playerOne, Player playerTwo, int laps)
    {
        m_PlayerOne = playerOne;
        m_PlayerTwo = playerTwo;
        m_Laps = laps;
    }

    Logic logic = new Logic(m_PlayerOne, m_PlayerTwo, m_Laps);


    JPanel middleLine = new JPanel();
    JLabel winnerText = new JLabel();
    JLabel winnerName = new JLabel();
    JLabel showNamePlayerOne = new JLabel();
    JLabel showNamePlayerTwo = new JLabel();
    JButton throwPlayerOne = new JButton();
    JButton throwPlayerTwo = new JButton();
    JButton stopButton = new JButton("STOP");

    public void start()
    {
    setLayout(null);

        middleLine.setBounds(695, 0, 100, 700);
        middleLine.setBackground(Color.BLACK);
        middleLine.setVisible(true);
        add(middleLine);

        // Der Spielername von Player 1 wird ins Spiel gesetzt,
        // die Position, die Schriftart
        // wird sich sichtbar gemacht und hinzugefuegt
        showNamePlayerOne.setText(m_PlayerOne.getName());
        showNamePlayerOne.setBounds(235, 10, 300, 100);
        showNamePlayerOne.setFont(new Font("courier", 60, 60));
        showNamePlayerOne.setVisible(true);
        add(showNamePlayerOne);

        // Der Spielername von Player 2 wird ins Spiel gesetzt,
        // die Position, die Schriftart
        // wird sich sichtbar gemacht und hinzugefuegt
        showNamePlayerTwo.setText(m_PlayerTwo.getName());
        showNamePlayerTwo.setBounds(1100, 10, 300, 100);
        showNamePlayerTwo.setFont(new Font("courier", 60, 60));
        showNamePlayerTwo.setVisible(true);
        add(showNamePlayerTwo);

        // Es wird ein gewinner satz ins Spiel hinzugefuegt
        // die Position gesetzt, die Schriftfahrt, nicht sichtbar, und hinzugefuegt
        winnerText.setBounds(350, 100, 900, 150);
        winnerText.setFont(new Font("courier", 90, 90));
        winnerText.setVisible(false);
        add(winnerText);

        // Es wird der gewinner Name ins Spiel hinzugefuegt
        // die Position gesetzt, die Schriftfahrt, nicht sichtbar, und hinzugefuegt
        winnerName.setBounds(250, 400, 1500, 150);
        winnerName.setFont(new Font("courier", 90, 90));
        winnerName.setVisible(false);
        add(winnerName);

        // Der Button, von Player1 wird hinzugefuegt und konfiguriert
        // Wenn dieser wird der ActionListener aufgerufen
        throwPlayerOne.setText(m_PlayerOne.getName());
        throwPlayerOne.setBounds(4, 720, 100, 40);
        throwPlayerOne.setVisible(true);
        throwPlayerOne.addActionListener(this);
        add(throwPlayerOne);

        // Der Stopn Button wird hinzugefuegt und konfiguriert
        // Wenn dieser wird der ActionListener aufgerufen
        stopButton.setBounds(695, 720, 100, 40);
        stopButton.setVisible(true);
        stopButton.addActionListener(this);
        add(stopButton);

        // Der Button, von Player2 wird hinzugefuegt und konfiguriert
        // Wenn dieser wird der ActionListener aufgerufen
        throwPlayerTwo.setText(m_PlayerTwo.getName());
        throwPlayerTwo.setBounds(1383, 720, 100, 40);
        throwPlayerTwo.setVisible(true);
        throwPlayerTwo.addActionListener(this);
        add(throwPlayerTwo);

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Wenn auf "X" oben links geklickt wird schliesst sich das Fenster
        setTitle("Dice Game"); // Der Titel des Fenster wird deklariert
        setSize(1500, 800); // Die Groesse des Fensters wird deklariert
        setVisible(true); // Das Fenster wird als Sichbar deklariert


    }



    @Override
    public void actionPerformed(ActionEvent nextAction)
    {
        if (nextAction.getSource() == throwPlayerOne)
        {
            logic.playerOne();
        }
        else if (nextAction.getSource() == stopButton)
        {
            logic.change();
        }
        else
        {
            logic.playerTwo();
        }

        if (logic.finish())
        {

        }
    }
}
