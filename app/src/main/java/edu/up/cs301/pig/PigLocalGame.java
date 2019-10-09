package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState gState;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        PigGameState gState = new PigGameState();

    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(gState.getPlayerID() == playerIdx){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        Random rand = new Random();
        int currentPlayer = gState.getPlayerID();
        int roll = rand.nextInt(5)+1;
        int currentT = gState.getCurrentTotal();
        int total = currentT + roll;
        if(action instanceof PigRollAction){
            // roll stuff
            gState.setCurrentDie(rand.nextInt(roll));
            if (roll == 1){
                gState.setCurrentTotal(0);
                if(currentPlayer == 0){
                    gState.setPlayerID(1);
                }
                else{
                    gState.setPlayerID(0);
                }
            }
            else{
                gState.setCurrentTotal(total);
            }
            return true;
        }
        else if(action instanceof PigHoldAction){
            // hold stuff
            if(currentPlayer == 0){
                gState.setPlayer0score(currentT);
                gState.setPlayerID(1);
            }
            else {
                gState.setPlayer1score(currentT);
                gState.setPlayerID(0);
            }
            gState.setCurrentTotal(0);
            return true;
        }
        return false;

    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState gState2 = gState;
        p.sendInfo(gState2);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(gState.getPlayer0score() >= 50){
            Log.d(TAG, "checkIfGameOver: Player 0 wins with " + gState.getPlayer0score() + "points!");
        }
        else if(gState.getPlayer1score() >= 50){
            Log.d(TAG, "checkIfGameOver: Player 1 wins with " + gState.getPlayer1score() + "points!");
        }
        return null;
    }

}// class PigLocalGame
