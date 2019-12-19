package com.java.Dice_Game;

public class Player
{
    private String m_Name;
    private int m_ScoreThrown;
    private int m_ScoreAbsolute;
    private boolean m_CanRoll = true;
    private boolean m_canSetPanel = true;

    public Player(String name, int scoreThrown, int scoreAbsolute, boolean canRoll, boolean canSetPanel)
    {
        m_Name = name;
        m_ScoreThrown = scoreThrown;
        m_ScoreAbsolute = scoreAbsolute;
        m_CanRoll = canRoll;
        m_canSetPanel = canSetPanel;
    }

    public String getName() { return m_Name; }
    public int getScoreThrown() { return m_ScoreThrown; }
    public int getScoreAbsolute() { return m_ScoreAbsolute; }
    public boolean isCanRoll() { return m_CanRoll; }
    public boolean isCanSetPanel() { return m_canSetPanel; }

    public void setName(String name) { m_Name = name; }
    public void setScoreThrown(int scoreThrown) { m_ScoreThrown = scoreThrown; }
    public void setScoreAbsolute(int scoreAbsolute) { m_ScoreAbsolute = scoreAbsolute; }
    public void setCanRoll(boolean canRoll) { m_CanRoll = canRoll; }
    public void setCanSetPanel(boolean canSetPanel) { m_canSetPanel = canSetPanel; }
}
