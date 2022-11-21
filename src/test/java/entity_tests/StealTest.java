package entity_tests;

import entity.*;
import entity.monster.Steal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StealTest {

    String[] items = new String[]{"Essence"};
    Steal steal = new Steal(items);

    /** Makes a new Player with the given Essence count. */
    private Player makePlayer(int n){
        int[] location = new int[]{1, 2};
        Weapon sword = new Weapon("Sword", 5);
        Armor armor = new Armor("Shield", 5);
        BasicEquipmentSlots equipment = new BasicEquipmentSlots(sword, armor);
        Collectible essence = new Collectible("Essence", n);
        Collectible artifact = new Collectible("Artifact");
        CollectibleInventory collect = new CollectibleInventory("1", essence, artifact);
        return new Player(5, 5, collect, equipment, location);
    }

    /** Tests Monster.isMustBeat. */
    @Test
    void testIsMustBeat(){
        Assertions.assertFalse(steal.isMustBeat());
    }

    /** Tests Steal.usePower when the item to be stolen has a count of 0. Steals nothing. */
    @Test
    void testUsePowerNone(){
        Player player = makePlayer(0);
        String result = steal.usePower(player);
        Assertions.assertEquals("Hurray! Nothing was stolen!", result);
        Assertions.assertEquals(0, player.getEssence().getNum());
    }

    /** Tests Steal.usePower when the item to be stolen has a count of less than 4. Always steals 1. */
    @Test
    void testUsePowerLess(){
        Player player = makePlayer(3);
        String result = steal.usePower(player);
        Assertions.assertEquals("1 Essence stolen.", result);
        // checks that the output is correct
        Assertions.assertEquals(2, player.getEssence().getNum());
        // checks that item count was reduced
    }

    /** Tests Steal.usePower when the item to be stolen has a count of 4. Steals 1 item. */
    @Test
    void testUsePowerEnough(){
        Player player = makePlayer(4);
        String result = steal.usePower(player);
        Assertions.assertEquals("1 Essence stolen.", result);
        //checks the output
        Assertions.assertEquals(3, player.getEssence().getNum());
        // checks that item count was reduced
    }


    /**Tests Steal.usePower when the item to be stolen has a count greater than 4. Steals max 1/4 of the
     * item count.
     * */
    @Test
    void testUsePowerGreater(){
        Player player = makePlayer(8);
        String result = steal.usePower(player);
        if (result.equals("2 Essence(s) stolen.")){
            Assertions.assertEquals(6, player.getEssence().getNum());
        } else if (result.equals("1 Essence stolen.")) {
            Assertions.assertEquals(7, player.getEssence().getNum());
        }

    }
}
