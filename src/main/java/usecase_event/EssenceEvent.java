package usecase_event;

import entity.Player;

import java.util.Random;

public class EssenceEvent extends Event{

    /**
     * Triggering this Event adds a random amount to the Essence that the player holds
     *
     * @param player the player triggering the Event
     */
    @Override
    public void trigger(Player player) {

        Random random = new Random();
        int random_int = random.nextInt(500);
        increaseEssence(player, random_int + 1);
    }

    /**Adds the Essence by random amount from 0 to 500
     *
     * @param player the player triggering the Event
     *
     */
    private void increaseEssence(Player player, int random){

        player.changeEssenceAmount(random);
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
