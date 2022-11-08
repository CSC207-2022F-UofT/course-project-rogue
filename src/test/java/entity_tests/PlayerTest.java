package entity_tests;

import entity.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PlayerTest {
    int maxHP = 100;
    int atkPt = 10;
    Collectible essence = new Collectible("Essence", 100);
    Collectible artifact = new Collectible("Artifact", 1);
    CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    Armor armor = new Armor("Chain Mail", 5);
    Weapon excalibur = new Weapon("Legendary Sword Excalibur", 1000);
    BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(excalibur, armor);
    int[] location = new int[]{0, 0};
    Player player;


    @BeforeEach
    @DisplayName("Creates the same Player class before each test")
    void setUp(){
        player = new Player(maxHP, atkPt, inventory, equipmentSlots, location);
    }

    @Test
    @DisplayName("Test Get Equipment")
    void testGetEquipment(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(excalibur, player.getEquipment("Weapon")),
                () -> Assertions.assertEquals(armor, player.getEquipment("Armor"))
        );
    }

    @Test
    @DisplayName("Test Get Collectible")
    void testGetCollectible(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(essence, player.getCollectible("Essence")),
                () -> Assertions.assertEquals(artifact, player.getCollectible("Artifact"))
        );
    }
}

