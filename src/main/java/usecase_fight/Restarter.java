package usecase_fight;

import entity.player.Player;
import interface_adapters.OutputBoundary;

import java.util.Observable;
import java.util.Observer;

/** A restarter that restarts the game from last Player save. */
public class Restarter implements Observer {
    private final OutputBoundary outputBoundary;
    private final Player player;
    /** The keystroke that triggers this restarter. */
    private final String trigger; // (Continue key)

    /**
     * Creates a Restarter with the given Player and trigger string.
     * @param player A given Player.
     * @param trigger The string that triggers Restarter to update.
     */
    public Restarter(OutputBoundary outputBoundary, Player player, String trigger){
        this.outputBoundary = outputBoundary;
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
