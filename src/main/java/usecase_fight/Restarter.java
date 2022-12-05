package usecase_fight;

import entity.player.Player;

import java.util.Observable;
import java.util.Observer;

/** A path in which the user loses the game. */
public class Restarter extends FightPath implements Observer {
    private final Player player;
    /** The keystroke that triggers this restarter. */
    private final String trigger; // (Continue key)

    /**
     * Creates a Restarter with the given Player and trigger string.
     *
     * @param player  A given Player.
     * @param trigger The string that triggers Restarter to update.
     */
    public Restarter(Player player, String trigger){
        this.player = player;
        this.trigger = trigger;
    }

    /**
     * Causes the game to go back to the main menu if the Player is in a game over state.
     * @param o     the observable object.
     * @param arg   key input string
     */
    @Override
    public void update(Observable o, Object arg) {
        if (player.getGameOver() && trigger.equals(arg)){
            outputBoundary.updateDead();
        }
    }
}
