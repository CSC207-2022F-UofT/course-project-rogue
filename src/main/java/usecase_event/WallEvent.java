package usecase_event;

import entity.player.Player;

public class WallEvent extends Event{


    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(Player player) {
        return false;
    }

    /**
     *  Returns String to show which Event type it is
     * @return "WallEvent"
     */
    @Override
    public String toString() {
        return "WallEvent";
    }

}
