package com.java.Dice_Game;

import java.lang.reflect.Array;

public class Logic {
    public boolean finish;

    private Player m_PlayerOne;
    private Player m_PlayerTwo;
    private int m_laps;
    private int m_TimesPlayerThrown = 0;
    static final int MAX_PLAYER_CAN_THROW_PER_ROUND = 5;
    static final int PLAYER_STARTS_NEW_ROUND_RESETS_THROWS_PER_ROUND = 0;
    static final int RESET_THROWN_SCORE = 0;

    Starter restart = new Starter();


    public Logic(Player playerOne, Player playerTwo, int laps)
    {
        m_PlayerOne = playerOne;
        m_PlayerTwo = playerTwo;
        m_laps = laps;
    }

    public void playerOne()
    {
        m_PlayerOne.setCanRoll(true);
        m_PlayerTwo.setCanRoll(false);

        if (m_PlayerOne.isCanSetPanel() == true && m_laps != 0)
        {
            //TODO: panels add
            m_PlayerOne.setCanSetPanel(false);
        }

        if (m_PlayerOne.isCanRoll() == true && m_TimesPlayerThrown < 6 && m_TimesPlayerThrown > 0 && m_laps != 0)
        {
            m_PlayerOne.setScoreThrown(throwDice());
            //TODO: Add thrown value to the panel

            if (checkIfNumberIsEven(m_PlayerOne.getScoreThrown()))
            {
                m_PlayerOne.setScoreAbsolute(scoreAdministration(m_PlayerOne.getScoreAbsolute(), 
					m_PlayerOne.getScoreThrown(), checkIfNumberIsEven(m_PlayerOne.getScoreThrown()));
                //TODO: Show score in panel
                m_TimesPlayerThrown++;

            }
            else if (m_TimesPlayerThrown >= MAX_PLAYER_CAN_THROW_PER_ROUND)
            {
                m_TimesPlayerThrown = PLAYER_STARTS_NEW_ROUND_RESETS_THROWS_PER_ROUND;

                m_PlayerOne.setCanRoll(false);
                m_PlayerTwo.setCanRoll(true);
                //TODO: set player one is accesed to set panels again

                m_PlayerOne.setScoreThrown(RESET_THROWN_SCORE);
            }
            else
            {
                m_PlayerOne.setScoreAbsolute(scoreAdministration(m_PlayerOne.getScoreAbsolute(), 
					m_PlayerOne.getScoreThrown(), checkIfNumberIsEven(m_PlayerOne.getScoreThrown()));

                //TODO: Show score in panel

                m_TimesPlayerThrown = PLAYER_STARTS_NEW_ROUND_RESETS_THROWS_PER_ROUND;

                //TODO: set player one is accesed to set panels again
            }
        }
    }


    public void change() {
    }

    public void playerTwo() {
    }

    public boolean finish() {
        return true;
    }

    public int throwDice()
    {
        int thrownValue = (int) (Math.random() * 6 + 1);
        return thrownValue;
    }

    boolean checkIfNumberIsEven(int scoreThrown)
    {
        if (scoreThrown != 0 && scoreThrown > 6)
        {
            if (scoreThrown % 2 == 0)
            {
                return true;
            }
            return false;
        }
    
		restart();
        return Boolean.parseBoolean(null);
    }

    public int addScore(int absoluteScore, int thrownScore, boolean valueEven)
    {
		if(valueEven)
		{
			return absoluteScore += thrownScore;
		}
		else
		{
			return absoluteScore -= thrownScore;
		}
	}
	
	public void restart()
	{
		String[] args = new String[0];
		
        restart.main(args);
	}
	
}
