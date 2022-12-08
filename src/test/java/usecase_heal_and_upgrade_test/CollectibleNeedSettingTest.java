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
import usecase_playeractions.Map;

public class CollectibleNeedSettingTest {
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


    @BeforeEach
    @DisplayName("Setup before Each Test")
    void setUp() {
        map = new Map();
        player = new Player(maxHP, atkPt, inventory, equipmentSlots);
    }

    @Test
    @DisplayName("Test Essence need for Heal")
    void TestEssenceForHeal() {
        CollectibleNeedSetting collectibleNeedSetting = new CollectibleNeedSetting();
        int HP = 20;
        Assertions.assertEquals(collectibleNeedSetting.essenceForHeal(HP), HP);
    }

    @Test
    @DisplayName("Test Essence need for Heal")
    void TestEssenceForUpgrade() {
        CollectibleNeedSetting collectibleNeedSetting = new CollectibleNeedSetting();
        Assertions.assertEquals(collectibleNeedSetting.essenceForUpgrade, 20);
    }
}
