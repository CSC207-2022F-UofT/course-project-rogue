package usecase_event_tests;

import entity.equipment_slots.BasicEquipmentSlots;
import entity.inventory_slots.CollectibleInventory;
import entity.item.Armor;
import entity.item.Collectible;
import entity.item.Weapon;
import entity.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_event.ArtifactEvent;


public class ArtifactEventTest {
    int maxHP = 100;
    int atkPt = 10;
    Collectible essence = new Collectible("Essence", 100);
    Collectible artifact = new Collectible("Artifact", 1);
    CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    Armor armor = new Armor("Chain Mail", 5);
    Weapon excalibur = new Weapon("Legendary Sword Excalibur", 1000);
    BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(excalibur, armor);
    Player player;
    ArtifactEvent event;



    @BeforeEach
    @DisplayName("Setup before Each Test")
    void setUp(){
        event = new ArtifactEvent();
        player = new Player(maxHP, atkPt, inventory, equipmentSlots);
    }

    @Test
    @DisplayName("Test Enter")
    void testEnter(){
        Assertions.assertTrue(event.enter(player));
    }
}
