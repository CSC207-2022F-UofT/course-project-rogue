package usecase_event;

import entity.Player;

public class FightEvent extends Event{
    @Override
    public Object trigger(Player player) {
        return null;
    }
    @Override
    public boolean enter(){
        /** Tells Map whether this tile could be stepped on by Player
         *
         * @returns True if player can step on it, false if it can's
         */
        return true;
    }
}
