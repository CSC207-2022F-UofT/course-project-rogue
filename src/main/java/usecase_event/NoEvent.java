package usecase_event;

import entity.player.Player;
import interface_adapters.OutputBoundary;

public class NoEvent extends Event{

    public NoEvent(OutputBoundary outputBoundary) {
        super(outputBoundary);
    }

    /**
     * Triggering this Event lets the player choose to either heal or upgrade their weapon once. The Player also has the
     * choice to neither heal nor upgrade if they have insufficient essence.
     *
     * @param player the player triggering the Event
     */
    @Override
    public void trigger(Player player) {
        player.setCanHeal(true);
        player.setCanMove(false);
        // And then let player choose if they want to heal or upgrade
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(Player player){

        return true;
    }
}