package usecase_event;

import entity.Player;

public class WallEvent extends Event{

    /**Triggering this Event does nothing
     *
     * @param: player: the player triggering the Event
     *
     * @return nothing happens, player cannot step on this event.
     */
    @Override
    public boolean trigger(Player player) {
        return false;
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter() {
        return false;
    }

}
