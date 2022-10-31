package Usecase_Event;

import java.util.Random;
import Entity.Player;

public class RandomEvent extends Event implements Triggerable{
    @Override
    public Object trigger(Player player) {
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

}
