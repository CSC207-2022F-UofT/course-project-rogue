package usecase_event;

import entity.player.Player;
import interface_adapters.OutputBoundary;

abstract public class Event implements Enterable{

    OutputBoundary outputBoundary;

    public Event(OutputBoundary outputBoundary){
        this.outputBoundary = outputBoundary;
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    public boolean enter(Player player) {

        return false;
    }
    public abstract void trigger(Player player);

}
