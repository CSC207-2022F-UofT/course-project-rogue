package entity.monster;

import entity.Character;
import entity.Item;
import entity.Player;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;


/** A Power that allows a Monster to steal a random number of one type of Item from the Player. */
public class Steal extends MonsterPower{

    /** A list of stealable items in Player inventory. */
    private static final ArrayList<String> stealable = new ArrayList<>();
    // ArrayList to allow for extension of adding new items (if not final). Can add a method that prevents duplicates
    // if we want to change what can get stolen, just change value in data file
    // no getter for now since I don't think I need to access it


    /**
     * Creates a new Steal power that allows Monster to steal the given items.
     *
     * @param items A list of String representations of Collectibles that the Monster can steal from Player.
     */
    public Steal(String[] items){
        super(false); // the Monster only steals if the Player does not beat the Monster
        stealable.addAll(Arrays.asList(items));
        // Before making a Monster with a Power, the Power needs to be initialized (Power data file)
        // this file should contain the list of all the items (in strings) that can be stolen
        // Ex: for now since we will only allow essence, under power: Steal we have the list ["Essence"].
    }


    /**
     * Steals an item from Player.
     *
     * @param player The Player that the Monster is stealing from.
     * @return A String describing the number of items stolen from the Player.
     */
    @Override
    public String usePower(Character player){
        String item = this.randomItem();
        Item toSteal = item.equals("Artifact")? ((Player)player).getArtifact():((Player)player).getEssence();
        int possible = toSteal.getNum();
        int max = (toSteal.getNum())/4; // Just decided on 1/4 of Players current amount for now, open to change
        int stolen = this.steal(toSteal, max, possible);
        if (stolen == 0){
            return "Hurray! Nothing was stolen!";
        } else if (stolen == 1) {
            return String.format("1 %s stolen.", toSteal);
        } else{
            return String.format("%d %s(s) stolen.", stolen, toSteal);
        }
    }

    /**
     * Decreases the count of the given item in Players inventory by a minimum of 1 to the given maximum.
     * If the count of the given item is 0, then nothing is stolen. If the count i
     *
     * @param item The Item that the Monster will steal from the Player.
     * @param max The maximum amount that can be stolen from Player.
     *
     * @return The number of items stolen.
     */
    private int steal(Item item, int max, int possible){
        Random random = new Random();
        if (max == 0) {
            if (possible == 0) {
                return 0;
            }
            item.changeNum(-1);
            return 1;
        }
        int stolen = random.nextInt(max) + 1; // steal a random number from 1 to max inclusive
        // stolen is always maximum one quarter of the Collectible count
        item.changeNum(-stolen);
        return (stolen);
    }

    /**
     * Selects a random Item to steal from Player based on items in stealable.
     */
    private String randomItem(){
        Random rand = new Random();
        int index = rand.nextInt(stealable.size()); // random index from 0 to size exclusive
        return stealable.get(index);
    }
}
