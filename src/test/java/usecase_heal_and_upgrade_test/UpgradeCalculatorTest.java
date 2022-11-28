package usecase_heal_and_upgrade_test;

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
import usecase_heal_and_upgrade.UpgradeCalculator;
import usecase_playeractions.Map;

public class UpgradeCalculatorTest {
    Map map;
    Player player;
    int maxHP = 100;
    int atkPt = 10;
    Collectible essence = new Collectible("Essence", 100);
    Collectible artifact = new Collectible("Artifact", 0);
    CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    Armor armor = new Armor("Chain Mail", 5);
    Weapon excalibur = new Weapon("Legendary Sword Excalibur", 1000);
    BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(excalibur, armor);
    int[] location = new int[]{0, 0};


    @BeforeEach
    @DisplayName("Setup before Each Test")
    void setUp(){
        player = new Player(maxHP, atkPt, inventory, equipmentSlots, location);
    }
    @Test
    @DisplayName("Test Upgrade Calculator")
    void testUpgradeCalculator(){
        player.setCanUpgrade(true);
        UpgradeCalculator weaponUpgradeCalculator = new UpgradeCalculator(player, "Weapon");
        weaponUpgradeCalculator.UpgradeInfoUpdate();
        weaponUpgradeCalculator.upgrade();
        Assertions.assertEquals(player.getWeapon().getStatValue(), 1020);
    }

    @Test
    @DisplayName("Test essence is used after upgrade")
    void testEssenceIsUsed(){
        player.setCanUpgrade(true);
        UpgradeCalculator weaponUpgradeCalculator = new UpgradeCalculator(player, "Weapon");
        weaponUpgradeCalculator.UpgradeInfoUpdate();
        weaponUpgradeCalculator.upgrade();
        Assertions.assertEquals(player.getEssence().getNum(),80);
    }

    @Test
    @DisplayName("Test will not upgrade when Essence not enough")
    void testEssenceNotEnough(){
        player.setCanUpgrade(true);
        UpgradeCalculator weaponUpgradeCalculator = new UpgradeCalculator(player, "Weapon");
        player.changeEssenceAmount(-90);
        weaponUpgradeCalculator.UpgradeInfoUpdate();
        weaponUpgradeCalculator.upgrade();
        Assertions.assertEquals(player.getWeapon().getStatValue(), 1000);
    }
}
