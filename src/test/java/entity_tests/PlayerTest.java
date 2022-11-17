package entity_tests;

import entity.*;
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
    @DisplayName("Setup before Each Test")
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
    void testForExceptionsOfGetEquipment(){
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
    @DisplayName("Test Change Current Hit Point")
    void testSubtractCurrentHitPoint(){
        Assertions.assertAll(
                () -> player.changeCurrHitPoint(-20),
                () -> Assertions.assertEquals(80, player.getCurrHitPoint()),
                () -> player.changeCurrHitPoint(-300),
                () -> Assertions.assertEquals(0, player.getCurrHitPoint()),
                () -> player.changeCurrHitPoint(52),
                () -> Assertions.assertEquals(52, player.getCurrHitPoint()),
                () -> player.changeCurrHitPoint(30130),
                () -> Assertions.assertEquals(maxHP, player.getCurrHitPoint())
        );
    }

    @Test
    @DisplayName("Test Set Location of Player")
    void testSetLocation(){
        player.setLocation(0, 4);
        int[] expected = {4, 0};
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected[0], player.getPlayerLocation()[0]),
                () -> Assertions.assertEquals(expected[1], player.getPlayerLocation()[1])
        );
    }

    @Test
    @DisplayName("Test Exception of Set Player Location")
    void testForExceptionForSetPlayerLocation(){
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->
                player.setLocation(3, 1));
        String expectedMessage = "out of bounds";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test Change Collectible Amount")
    void testChangeCollectibleAmount(){
        Assertions.assertAll(
                () -> player.changeCollectibleAmount("Essence", 20),
                () -> Assertions.assertEquals(120, player.getCollectible("Essence").getNum()),
                () -> player.changeCollectibleAmount("Artifact", 2),
                () -> Assertions.assertEquals(3, player.getCollectible("Artifact").getNum()),
                () -> player.changeCollectibleAmount("Essence", -300),
                () -> Assertions.assertEquals(0, player.getCollectible("Essence").getNum()),
                () -> player.changeCollectibleAmount("Artifact", -30),
                () -> Assertions.assertEquals(0, player.getCollectible("Artifact").getNum())
        );
    }

    @Test
    @DisplayName("Test for Changing Armor")
    void testChangeArmor(){
        Armor aegisShield = new Armor("Aegis Shield", 600000);
        player.setEquipment(aegisShield);
        Assertions.assertEquals(aegisShield, player.getEquipment("Armor"));
    }

    @Test
    @DisplayName("Test for Changing Weapon")
    void testChangeWeapon(){
        Weapon durandal = new Weapon("Legendary Sword Durandal", 1001);
        player.setEquipment(durandal);
        Assertions.assertEquals(durandal, player.getEquipment("Weapon"));
    }

    @Test
    @DisplayName("Test for get can Move")
    void testGetCanMove(){
        Assertions.assertTrue(player.getCanMove());
    }
    @Test
    @DisplayName("Test for get can Heal")
    void testGetCanHeal(){
        Assertions.assertFalse(player.getCanHeal());
    }

    @Test
    @DisplayName("Test for get can upgrade")
    void testGetCanUpgrade(){
        Assertions.assertFalse(player.getCanUpgrade());
    }

    @Test
    @DisplayName("Test for get is Fighting")
    void testGetFighting(){
        Assertions.assertFalse(player.getFighting());
    }
    @Test
    @DisplayName("Test for get is Upgrading")
    void testGetUpgrading(){
        Assertions.assertFalse(player.getUpgrading());
    }

    @Test
    @DisplayName("Test for set can Move")
    void testSetCanMove(){
        player.setCanMove(false);
        Assertions.assertFalse(player.getCanMove());
    }
    @Test
    @DisplayName("Test for set can Heal")
    void testSetCanHeal(){
        player.setCanHeal(true);
        Assertions.assertTrue(player.getCanHeal());
    }

    @Test
    @DisplayName("Test for set can upgrade")
    void testSetCanUpgrade(){
        player.setCanUpgrade(true);
        Assertions.assertTrue(player.getCanUpgrade());
    }

    @Test
    @DisplayName("Test for set is Fighting")
    void testSetFighting(){
        player.setFighting(true);
        Assertions.assertTrue(player.getFighting());
    }
    @Test
    @DisplayName("Test for set is upgrading")
    void testSetUpgrading(){
        player.setUpgrading(true);
        Assertions.assertTrue(player.getUpgrading());
    }
}

