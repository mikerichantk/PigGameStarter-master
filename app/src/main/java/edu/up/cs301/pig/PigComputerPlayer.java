package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        if(info instanceof PigGameState){
            if(((PigGameState) info).getPlayerID() != playerNum){
                return;
            }
            else{
                Random rand = new Random();
                int weewoo = rand.nextInt(2);
                if(weewoo == 0){
                    PigHoldAction holdweewoo = new PigHoldAction(this);
                    game.sendAction(holdweewoo);
                    return;
                }
                else{
                    PigRollAction rollweewoos = new PigRollAction(this);
                    game.sendAction(rollweewoos);
                    return;
                }
            }
        }

    }//receiveInfo

}
