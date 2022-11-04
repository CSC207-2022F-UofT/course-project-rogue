package usecase_event;

import entity.Player;

public class NoEvent extends Event{
    @Override
    public Object trigger(Player player) {
        /**Triggering this Event lets the player choose to either heal or upgrade their weapon
         *
         * @param: player: the player triggering the Event
         *
         * @returns The player heals or upgrade their weapon
         */
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
