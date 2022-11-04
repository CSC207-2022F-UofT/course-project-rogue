package usecase_event;

import entity.Player;

public class FightEvent extends Event{
    @Override
    public boolean trigger(Player player) {
        return true;
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(){
        return true;
    }
}
