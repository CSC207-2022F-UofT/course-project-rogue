package usecase_event;

import entity.player.Player;
import interface_adapters.OutputBoundary;

public class Event implements Enterable{

    protected static OutputBoundary outputBoundary = null;

    public Event(OutputBoundary outputBoundary){
        Event.outputBoundary = outputBoundary;
    }

    public static void setOutputBoundary(OutputBoundary output){
        if(Event.outputBoundary == null) {
            Event.outputBoundary = output;
        }
    }
    public Event() {
    }


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
