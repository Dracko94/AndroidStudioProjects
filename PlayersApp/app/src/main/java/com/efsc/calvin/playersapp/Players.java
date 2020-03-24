package com.efsc.calvin.playersapp;

public class Players {
    private int playerID;
    private String playerName;
    private int playerWins;
    private int playerLosses;
    private int playerTies;

    public Players() {
        playerName = "";
    }

    public Players(int playerID, String playerName, int playerWins,
                   int playerLosses, int playerTies) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.playerWins = playerWins;
        this.playerLosses = playerLosses;
        this.playerTies = playerTies;
    }

    public int getID() {
        return playerID;
    }

    public void setID(int playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return playerName;
    }

    public void setName(String playerName) {
        this.playerName = playerName;
    }

    public int getWins() {
        return playerWins;
    }

    public void setWins(int playerWins) {
        this.playerWins = playerWins;
    }

    public int getLosses() {
        return playerLosses;
    }

    public void setLosses(int playerLosses)
    {
        this.playerLosses = playerLosses;
    }

    public int getTies()
    {
        return playerTies;
    }

    public void setTies(int playerTies)
    {
        this.playerTies = playerTies;
    }

}
