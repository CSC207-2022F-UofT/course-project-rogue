package usecase_event;

import entity.Player;

public class NoEvent extends Event{

    /**Triggering this Event lets the player choose to either heal or upgrade their weapon
     *
     * @param: player: the player triggering the Event
     *
     * @return The player heals or upgrade their weapon
     */
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
