package usecase_event;

import entity.player.Player;

public class WallEvent extends Event{

    /**
     * Triggering this Event does nothing
     *
     * @param: player: the player triggering the Event
     */
    @Override
    public void trigger(Player player) {
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(Player player) {
        return false;
    }

}
