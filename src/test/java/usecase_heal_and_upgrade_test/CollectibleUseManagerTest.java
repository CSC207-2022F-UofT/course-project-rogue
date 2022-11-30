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
import usecase_essence_use.data_calculator.CollectibleUseManager;
import usecase_playeractions.Map;

public class CollectibleUseManagerTest {
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
        map = new Map();
        player = new Player(maxHP, atkPt, inventory, equipmentSlots, location);
    }

    @Test
    @DisplayName("Test getAble when it's able")
    void TestGetAbleTrue(){
        CollectibleUseManager CollectHelper = new CollectibleUseManager(player,10);
        Assertions.assertEquals(CollectHelper.getAble(),true);
    }

    @Test
    @DisplayName("Test getAble when it's not able")
    void TestGetAbleFalse(){
        CollectibleUseManager CollectHelper = new CollectibleUseManager(player,110);
        Assertions.assertEquals(CollectHelper.getAble(),false);
    }

    @Test
    @DisplayName("Test the esence can be spent")
    void TestEssenceSpent(){
        CollectibleUseManager CollectHelper = new CollectibleUseManager(player,10);
        CollectHelper.spendCollectible();
        Assertions.assertEquals(player.getEssence().getNum(),90);
    }

}
