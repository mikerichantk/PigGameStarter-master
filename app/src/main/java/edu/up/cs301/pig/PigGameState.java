package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    // instance variables
    private int playerID;
    private int player0score;
    private int player1score;
    private int currentTotal;
    private int currentDie;

    // constructor
    public PigGameState(){
        this.playerID = 0;
        this.player0score = 0;
        this.player1score = 0;
        this.currentTotal = 0;
        this.currentDie = 0;

    }
    // copy constructor
    public PigGameState(PigGameState state){
        this.playerID = state.playerID;
        this.player0score = state.player0score;
        this.player1score = state.player1score;
        this.currentTotal = state.currentTotal;
        this.currentDie = state.currentDie;
    }
    // getter methods
    public int getPlayerID(){
        return this.playerID;
    }
    public int getPlayer0score(){
        return this.player0score;
    }
    public int getPlayer1score(){
        return this.player1score;
    }
    public int getCurrentTotal(){
        return this.currentTotal;
    }
    public int getCurrentDie(){
        return this.currentDie;
    }
    // setter methods
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    public void setPlayer0score(int player0score) {
        this.player0score = player0score;
    }
    public void setPlayer1score(int player1score) {
        this.player1score = player1score;
    }
    public void setCurrentTotal(int currentTotal) {
        this.currentTotal = currentTotal;
    }
    public void setCurrentDie(int currentDie) {
        this.currentDie = currentDie;
    }
}
