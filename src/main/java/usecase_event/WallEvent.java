package usecase_event;

import entity.player.Player;
import interface_adapters.OutputBoundary;

public class WallEvent extends Event{

    public WallEvent(OutputBoundary outputBoundary) {
        super(outputBoundary);
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(Player player) {
        return false;
    }

    @Override
    public void trigger(Player player) {
    }

}
