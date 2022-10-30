package Usecase_Event;

import Entity.Player;

import java.util.Random;

public class EssenceEvent implements Triggerable{
    @Override
    public Object trigger(Player player) {
        Random random = new Random();
        int random_int = random.nextInt(501);
        increaseEssence(player, random_int);
        return null;
    }
    private void increaseEssence(Player player, int random){
        player.setInventory("Essence", random);
    }
}
