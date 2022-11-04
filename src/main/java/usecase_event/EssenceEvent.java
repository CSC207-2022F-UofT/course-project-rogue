package usecase_event;

import entity.Player;

import java.util.Random;

public class EssenceEvent extends Event{
    @Override
    public Object trigger(Player player) {
        /**Triggering this Event adds a random amount to the Essence that the player holds
         *
         * @param: player: the player triggering the Event
         *
         * @returns Adds from 0 to 501 Essences to the player inventory
         */
        Random random = new Random();
        int random_int = random.nextInt(501);
        increaseEssence(player, random_int);
        return null;
    }
    private void increaseEssence(Player player, int random){
        /**Adds the Essence by random amount
         *
         * @param: player: the player triggering the Event
         *
         * @returns Adds the Essence by random amount in Player inventory
         */
        player.setInventory("Essence", random);
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
