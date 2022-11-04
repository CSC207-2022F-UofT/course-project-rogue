package usecase_event;

import entity.Player;

public class WallEvent extends Event{
    @Override
    public Object trigger(Player player) {
        /**Triggering this Event does nothing
         *
         * @param: player: the player triggering the Event
         *
         * @returns nothing happens, player cannot step on this event.
         */
        return null;
    }

    @Override
    public boolean enter() {
        /** Tells Map whether this tile could be stepped on by Player
         *
         * @returns True if player can step on it, false if it can's
         */
        return false;
    }

}
