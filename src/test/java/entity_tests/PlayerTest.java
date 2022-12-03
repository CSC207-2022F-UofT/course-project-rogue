package entity_tests;

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
        player = new Player(maxHP, atkPt, inventory, equipmentSlots);
    }

    @Test
    @DisplayName("Test Get Equipment")
    void testGetEquipment(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(excalibur, player.getWeapon()),
                () -> Assertions.assertEquals(armor, player.getArmor())
        );
    }

    @Test
    @DisplayName("Test Get Collectible")
    void testGetCollectible(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(essence, player.getEssence()),
                () -> Assertions.assertEquals(artifact, player.getArtifact())
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
                // 100 - 20 = 80
                () -> player.changeCurrHitPoint(-20),
                () -> Assertions.assertEquals(80, player.getCurrHitPoint()),
                // 100 - 300 = 0 (Because health cannot be negative)
                () -> player.changeCurrHitPoint(-300),
                () -> Assertions.assertEquals(0, player.getCurrHitPoint()),
                () -> player.changeCurrHitPoint(52),
                // 0 + 52 = 52
                () -> Assertions.assertEquals(52, player.getCurrHitPoint()),
                () -> player.changeCurrHitPoint(30130),
                // 52 + 30130 = 100 because max hp = 100
                () -> Assertions.assertEquals(maxHP, player.getCurrHitPoint())
        );
    }

    @Test
    @DisplayName("Test Set Location of Player")
    void testSetLocation(){
        player.setLocation(0, 4);
        int[] expected = {0, 4};
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
                () -> player.changeEssenceAmount(20),
                () -> Assertions.assertEquals(120, player.getEssence().getNum()),
                () -> player.changeArtifactAmount(2),
                () -> Assertions.assertEquals(3, player.getArtifact().getNum()),
                () -> player.changeEssenceAmount(-300),
                () -> Assertions.assertEquals(0, player.getEssence().getNum()),
                () -> player.changeArtifactAmount(-30),
                () -> Assertions.assertEquals(0, player.getArtifact().getNum())
        );
    }

    @Test
    @DisplayName("Test for Changing Armor")
    void testChangeArmor(){
        Armor aegisShield = new Armor("Aegis Shield", 600000);
        player.setEquipment(aegisShield);
        Assertions.assertEquals(aegisShield, player.getArmor());
    }

    @Test
    @DisplayName("Test for Changing Weapon")
    void testChangeWeapon(){
        Weapon durandal = new Weapon("Legendary Sword Durandal", 1001);
        player.setEquipment(durandal);
        Assertions.assertEquals(durandal, player.getWeapon());
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

    @Test
    @DisplayName("Test for getting Player Collectible Inventory")
    void testGetCollectibleInventory(){
        Assertions.assertEquals(inventory, player.getCollectibleInventory());
    }

    @Test
    @DisplayName("Test for getting Player Equipment Slot")
    void testGetEquipmentSlot(){
        Assertions.assertEquals(equipmentSlots, player.getEquipments());
    }
}

