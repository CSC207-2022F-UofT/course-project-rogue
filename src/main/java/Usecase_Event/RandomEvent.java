package Usecase_Event;

import java.util.Random;
import Entity.Player;

public class RandomEvent implements Triggerable{
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
            int random_int = random.nextInt(501);
            increaseEssence(player, random_int);
            return null;
        }
    }
    private void increaseEssence(Player player, int random){
        player.setInventory("Essence", random);
    }
}
