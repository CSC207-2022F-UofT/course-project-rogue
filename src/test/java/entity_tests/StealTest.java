package entity_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Weapon;
import entity.monster.Steal;

import entity.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StealTest {

    Steal steal = new Steal();

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
    @DisplayName("Test Is Must Beat")
    void testIsMustBeat(){
        Assertions.assertFalse(steal.isMustBeat());
    }

    /** Tests Steal.usePower when the item to be stolen has a count of 0. Steals nothing. */
    @Test
    @DisplayName("Test Use Power None")
    void testUsePowerNone(){
        Player player = makePlayer(0);
        String result = steal.usePower(player);
        Assertions.assertEquals("Nothing was stolen!", result);
        Assertions.assertEquals(0, player.getEssence().getNum());
    }

    /** Tests Steal.usePower when the item to be stolen has a count of less than 4. Always steals 1. */
    @Test
    @DisplayName("Test Use Power Less")
    void testUsePowerLess(){
        Player player = makePlayer(3);
        String result = steal.usePower(player);
        Assertions.assertEquals("1 essence stolen.", result);
        // checks that the output is correct
        Assertions.assertEquals(2, player.getEssence().getNum());
        // checks that item count was reduced
    }

    /** Tests Steal.usePower when the item to be stolen has a count of 4. Steals 1 item. */
    @Test
    @DisplayName("Test Use Power Enough")
    void testUsePowerEnough(){
        Player player = makePlayer(4);
        String result = steal.usePower(player);
        Assertions.assertEquals("1 essence stolen.", result);
        //checks the output
        Assertions.assertEquals(3, player.getEssence().getNum());
        // checks that item count was reduced
    }


    /**Tests Steal.usePower when the item to be stolen has a count greater than 4. Steals max 1/4 of the
     * item count.
     * */
    @Test
    @DisplayName("Test Use Power Greater")
    void testUsePowerGreater(){
        Player player = makePlayer(8);
        String result = steal.usePower(player);
        if (result.equals("2 essence stolen.")){
            Assertions.assertEquals(6, player.getEssence().getNum());
        } else if (result.equals("1 essence stolen.")) {
            Assertions.assertEquals(7, player.getEssence().getNum());
        }

    }
}
