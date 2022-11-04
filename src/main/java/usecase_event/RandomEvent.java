package usecase_event;

import java.util.Random;
import entity.Player;

public class RandomEvent extends Event{

    /**Triggering this Event randomly Triggers Fight Event, no Event or Essence Event
     *
     * @param: player: the player triggering the Event
     *
     * @return Triggers the respective Event randomly
     */
    @Override
    public boolean trigger(Player player) {
        Random random = new Random();
        int random_prob = random.nextInt(101);
        if (random_prob < 70){
            FightEvent fightEvent = new FightEvent();
            fightEvent.trigger(player);
            return true;
        }
        else {
            EssenceEvent essenceEvent = new EssenceEvent();
            essenceEvent.trigger(player);
            return true;
        }
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
