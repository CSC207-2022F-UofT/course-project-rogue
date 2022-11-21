package usecase_fight;

import entity.Player;

import java.util.Observable;
import java.util.Observer;

public class Restarter implements Observer {
    private final Player player;
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
     * Causes the game to restart from the last save.
     * @param o     the observable object.
     * @param arg   key input string
     */
    @Override
    public void update(Observable o, Object arg) {
        if (player.getGameOver() && trigger.equals(arg)){
            // restart from last save
        }
    }
}
