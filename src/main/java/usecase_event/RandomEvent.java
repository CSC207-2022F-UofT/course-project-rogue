package usecase_event;

import java.util.Random;
import entity.player.Player;
import interface_adapters.OutputBoundary;
import user_interface.View;
import user_interface.Visual;

public class RandomEvent extends Event{

    public RandomEvent(OutputBoundary outputBoundary) {
        super(outputBoundary);
    }

    /**
     * Triggering this Event randomly Triggers Fight Event, no Event or Essence Event
     *
     * @param player the player triggering the Event
     */
    @Override
    public void trigger(Player player) {
        Random random = new Random();
        int random_prob = random.nextInt(101);
        if (random_prob < 70){
            FightEvent fightEvent = new FightEvent(this.outputBoundary);
            fightEvent.trigger(player);
        }
        else {
            EssenceEvent essenceEvent = new EssenceEvent(this.outputBoundary);
            essenceEvent.trigger(player);
        }
    }

    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(Player player){

        return true;
    }

}
