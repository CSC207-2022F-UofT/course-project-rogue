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
import usecase_essence_use.heal.HealCalculator;
import usecase_playeractions.Map;

public class HealCalculatorTest {
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
        player = new Player(maxHP, atkPt, inventory, equipmentSlots);
    }

    @Test
    @DisplayName("Test HP loss")
    void testHPHave(){
        player.changeCurrHitPoint(-20);
        Assertions.assertEquals(player.getCurrHitPoint(),80);
    }

    @Test
    @DisplayName("Test HP is healed")
    void testHPIsHealed(){
        player.setCanHeal(true);
        player.changeCurrHitPoint(-20);
        HealCalculator healCalculator = new HealCalculator(player);
        healCalculator.healInfoUpdate();
        healCalculator.heal();
        Assertions.assertEquals(player.getCurrHitPoint(), 100);
    }

    @Test
    @DisplayName("Test Essence is spent")
    void testEssenceIsSpent(){
        player.setCanHeal(true);
        player.changeCurrHitPoint(-20);
        HealCalculator healCalculator = new HealCalculator(player);
        healCalculator.healInfoUpdate();
        healCalculator.heal();
        Assertions.assertEquals(player.getEssence().getNum(),80);
    }

    @Test
    @DisplayName("Test partly heal when essence are not enough")
    void testPartlyHeal(){
        player.setCanHeal(true);
        player.changeCurrHitPoint(-90);
        player.changeEssenceAmount(-90);
        HealCalculator healCalculator = new HealCalculator(player);
        healCalculator.healInfoUpdate();
        healCalculator.heal();
        Assertions.assertEquals(player.getCurrHitPoint(),20);
    }

    @Test
    @DisplayName("Test heal function is disabled after healing")
    void testCannotHeal(){
        player.setCanHeal(true);
        player.changeCurrHitPoint(-20);
        HealCalculator healCalculator = new HealCalculator(player);
        healCalculator.healInfoUpdate();
        healCalculator.heal();
        Assertions.assertEquals(player.getCanHeal(),false);
    }
}
