package usecase_fight;

import entity.Player;

import java.util.Observable;
import java.util.Observer;

/** A restarter that restarts the game from last Player save. */
public class Restarter implements Observer {
    private final Player player;
    /** The keystroke that triggers this restarter. */
    private final String trigger; // (Continue key)

    /**
     * Creates a Restarter with the given Player and trigger string.
     * @param player A given Player.
     * @param trigger The string that triggers Restarter to update.
     */
    public Restarter(Player player, String trigger){
        this.player = player;
        this.trigger = trigger;
    }

    /**
     * Causes the game to restart from the last save if the Player is in a game over state.
     * @param o     the observable object.
     * @param arg   key input string
     */
    @Override
    public void update(Observable o, Object arg) {
        if (player.getGameOver() && trigger.equals(arg)){
            // go to main menu
        }
    }
}
