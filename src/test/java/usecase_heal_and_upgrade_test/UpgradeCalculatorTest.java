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
import usecase_essence_use.data_preset_normal.CollectibleNeedSetting;
import usecase_essence_use.data_preset_normal.StatSetting;
import usecase_essence_use.manager.UpgradeManager;
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

    CollectibleNeedSetting essenceNeed = new CollectibleNeedSetting();
    StatSetting statSetting = new StatSetting();


    @BeforeEach
    @DisplayName("Setup before Each Test")
    void setUp(){
        map = new Map();
        player = new Player(maxHP, atkPt, inventory, equipmentSlots);
    }
    @Test
    @DisplayName("Test Upgrade Calculator")
    void testUpgradeCalculator(){
        player.setCanUpgrade(true);
        UpgradeManager weaponUpgradeCalculator = new UpgradeManager(player, "Weapon",essenceNeed, statSetting);
        weaponUpgradeCalculator.UpgradeInfoUpdate();
        weaponUpgradeCalculator.upgrade();
        Assertions.assertEquals(player.getWeapon().getStatValue(), 1020);
    }

    @Test
    @DisplayName("Test essence is used after upgrade")
    void testEssenceIsUsed(){
        player.setCanUpgrade(true);
        UpgradeManager weaponUpgradeCalculator = new UpgradeManager(player, "Weapon",essenceNeed, statSetting);
        weaponUpgradeCalculator.UpgradeInfoUpdate();
        weaponUpgradeCalculator.upgrade();
        Assertions.assertEquals(player.getEssence().getNum(),80);
    }

    @Test
    @DisplayName("Test will not upgrade when Essence not enough")
    void testEssenceNotEnough(){
        player.setCanUpgrade(true);
        UpgradeManager weaponUpgradeCalculator = new UpgradeManager(player, "Weapon",essenceNeed, statSetting);
        player.changeEssenceAmount(-90);
        weaponUpgradeCalculator.UpgradeInfoUpdate();
        weaponUpgradeCalculator.upgrade();
        Assertions.assertEquals(player.getWeapon().getStatValue(), 1000);
    }
}
