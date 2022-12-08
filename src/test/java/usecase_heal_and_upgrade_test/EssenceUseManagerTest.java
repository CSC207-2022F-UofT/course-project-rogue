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
import usecase_essence_use.manager.EssenceUseManager;
import usecase_playeractions.Map;

public class EssenceUseManagerTest {
    Map map;
    Player player;
    EssenceUseManager essenceUseManager;
    int maxHP = 100;
    int atkPt = 10;
    Collectible essence = new Collectible("Essence", 100);
    Collectible artifact = new Collectible("Artifact", 0);
    CollectibleInventory inventory = new CollectibleInventory("Collectible Inventory", essence, artifact);
    Armor armor = new Armor("Chain Mail", 5);
    Weapon excalibur = new Weapon("Legendary Sword Excalibur", 1000);
    BasicEquipmentSlots equipmentSlots = new BasicEquipmentSlots(excalibur, armor);
    CollectibleNeedSetting collectibleNeedSetting = new CollectibleNeedSetting();
    StatSetting statSetting = new StatSetting();


    @BeforeEach
    @DisplayName("Setup before Each Test")
    void setUp(){
        map = new Map();
        player = new Player(maxHP, atkPt, inventory, equipmentSlots);
        essenceUseManager = new EssenceUseManager(player, collectibleNeedSetting, statSetting);
    }

    @Test
    @DisplayName("Test getHealManager And getUpgradeManager")
    void TestGetHealManagerAndUpgradeManager(){
        Assertions.assertAll("Test the healManager and UpgradeManager is correctly built",
                () -> Assertions.assertNotNull(essenceUseManager.getArmorUpgradeManage()),
                () -> Assertions.assertNotNull(essenceUseManager.getHealManage()),
                () -> Assertions.assertNotNull(essenceUseManager.getWeaponUpgradeManage()));
    }

    @Test
    @DisplayName("Test manager initialization")
    void TestManagerInitialization(){
        essenceUseManager.initializeManager();
        Assertions.assertTrue(essenceUseManager.isInEssenceUse());
    }

    @Test
    @DisplayName("Test manager update")
    void TestManagerUpdate(){
        player.changeEssenceAmount(-60);
        player.changeCurrHitPoint(-90);
        essenceUseManager.updateInfo();
        essenceUseManager.getHealManage().heal();
        Assertions.assertEquals(player.getCurrHitPoint(),50);
    }

    @Test
    @DisplayName("Test isInpage")
    void TestisInPage(){
        essenceUseManager.setInPage(false);
        Assertions.assertFalse(essenceUseManager.isInPage());
    }
}
