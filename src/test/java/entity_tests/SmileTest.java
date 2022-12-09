package entity_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Weapon;
import entity.monster.Smile;
import entity.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SmileTest {

    final Collectible essence = new Collectible("Essence", 10);
    final Collectible artifact = new Collectible("Artifact", 1);
    final CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    final Armor armor = new Armor("Padded Jacket", 50);
    final Weapon weapon = new Weapon("Plastic Sword", 50);
    final BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(weapon, armor);
    Player player;
    Smile smile;

    @BeforeEach
    @DisplayName("Set up a smile power")
    void setUp(){
        smile = new Smile();
        player = new Player(20, 5, inventory, equipmentSlots);
    }

    @Test
    @DisplayName("Test that the return value for usePower is correct")
    void testUsePower(){
        String result = smile.usePower(player);
        Assertions.assertEquals("The bear smiled at you and left. Strange.", result);
    }

    @Test
    @DisplayName("Test the toString of this power")
    void testToString(){
        String result = smile.toString();
        Assertions.assertEquals("Unknown", result);
    }
}
