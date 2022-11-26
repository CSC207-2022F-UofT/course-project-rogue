package usecase_heal_and_upgrade_test;

import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_heal_and_upgrade.HealCalculator;
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
        player = new Player(maxHP, atkPt, inventory, equipmentSlots, location);
    }
    @Test
    @DisplayName("Test Heal Calculator")
    void testHealCalculator(){
        player.setCanHeal(true);
        HealCalculator healCalculator = new HealCalculator(player);
        player.changeCurrHitPoint(-20);
        healCalculator.HealInfoUpdate();
        healCalculator.heal();
        Assertions.assertEquals(player.getCurrHitPoint(), 100);
        Assertions.assertEquals(player.getEssence().getNum(), 80);
        Assertions.assertEquals(player.getCanHeal(), false);
    }
}
