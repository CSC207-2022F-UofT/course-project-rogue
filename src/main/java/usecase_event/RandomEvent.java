package usecase_event;

import java.util.Random;
import entity.Player;

public class RandomEvent extends Event{
    @Override
    public Object trigger(Player player) {
        /**Triggering this Event randomly Triggers Fight Event, no Event or Essence Event
         *
         * @param: player: the player triggering the Event
         *
         * @returns Triggers the respective Event randomly
         */
        Random random = new Random();
        int random_prob = random.nextInt(101);
        if (random_prob < 70){
            FightEvent fightEvent = new FightEvent();
            fightEvent.trigger(player);
            return null;
        }
        else {
            EssenceEvent essenceEvent = new EssenceEvent();
            essenceEvent.trigger(player);
            return null;
        }
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
