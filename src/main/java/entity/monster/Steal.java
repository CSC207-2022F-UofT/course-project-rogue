package entity.Monster;

import entity.Character;
import entity.Collectible;
import entity.Player;
import java.util.Random;


/** A Power that allows a Monster to steal a random number of essence from the Player. */
public class Steal extends MonsterPower{


    /**
     * Creates a new Steal power.
     */
    public Steal(){
        super(false); // the Monster only steals if the Player does not beat the Monster
    }


    /**
     * Steals an item from Player.
     *
     * @param player The Player that the Monster is stealing from.
     * @return A String describing the number of items stolen from the Player.
     */
    @Override
    public String usePower(Character player){
        Collectible toSteal = ((Player)player).getEssence();
        int possible = toSteal.getNum();
        int max = (toSteal.getNum())/4; // Just decided on 1/4 of Players current amount for now, open to change
        int stolen = this.steal(toSteal, max, possible);
        if (stolen == 0){
            return "Nothing was stolen!";
        } else if (stolen == 1) {
            return "1 essence stolen.";
        } else{
            return String.format("%d essence stolen.", stolen);
        }
    }

    /**
     * Decreases the count of essence in Players inventory by a minimum of 1 to the given maximum.
     * If the Player has 0 essence, then nothing is stolen.
     *
     * @param toSteal The essence object.
     * @param max The maximum amount that can be stolen from Player.
     * @param possible The highest possible amount that can be stolen.
     *
     * @return The number of essence stolen.
     */
    private int steal( Collectible toSteal, int max, int possible){
        Random random = new Random();
        if (max == 0) {
            if (possible == 0) {
                return 0;
            }
            toSteal.changeNum(-1);
            return 1;
        }
        int stolen = random.nextInt(max) + 1; // steal a random number from 1 to max inclusive
        // stolen is always maximum one quarter of the current count
        toSteal.changeNum(-stolen);
        return (stolen);
    }

    @Override
    public String toString(){
        return "Can steal your essence if not defeated.";
    }
}
