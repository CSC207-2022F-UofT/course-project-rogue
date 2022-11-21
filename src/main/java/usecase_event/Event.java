package usecase_event;

import entity.Player;

abstract public class Event implements Enterable{

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    public boolean enter(Player player) {

        return false;
    }
    public void trigger(Player player){
    }
}
