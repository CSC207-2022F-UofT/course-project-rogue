package entity_tests;

import entity.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


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
    @DisplayName("Test for Exceptions in getEquipment")
    void testForExceptions(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                player.getEquipment("SSS"));
        String expectedMessage = "equipmentType must be either Weapon or Armor";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test Get Collectible")
    void testGetCollectible(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(essence, player.getCollectible("Essence")),
                () -> Assertions.assertEquals(artifact, player.getCollectible("Artifact"))
        );
    }

    @Test
    @DisplayName("Test Get Max Hit Point")
    void testGetMaxHitPoint(){
        Assertions.assertEquals(maxHP, player.getMaxHitPoint());
    }

    @Test
    @DisplayName("Test Get Currect Hit Point")
    void testGetCurrentHitPoint(){
        Assertions.assertEquals(maxHP, player.getCurrHitPoint());
    }

    @Test
    @DisplayName("Test Get Attack Point")
    void testGetAttackPoint(){
        Assertions.assertEquals(atkPt, player.getAttackPoint());
    }

    @Test
    @DisplayName("Test Get Player Location")
    void testGetPlayerLocation(){
        Assertions.assertEquals(location, player.getPlayerLocation());
    }

    @Test
    @DisplayName("Test Subtract Current Hit Point")
    void testSubtractCurrentHitPoint(){
        player.changeCurrHitPoint(-20);
        Assertions.assertEquals(80, player.getCurrHitPoint());
    }
}

