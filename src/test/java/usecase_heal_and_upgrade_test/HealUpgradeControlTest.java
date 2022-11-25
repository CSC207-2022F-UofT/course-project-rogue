package usecase_heal_and_upgrade_test;

import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import usecase_heal_and_upgrade.HealCalculator;
import usecase_heal_and_upgrade.HealUpgradeCalculator;
import usecase_heal_and_upgrade.HealingUpgradingControl;
import usecase_heal_and_upgrade.UpgradeCalculator;
import usecase_playeractions.Map;

public class HealUpgradeControlTest {
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
    @DisplayName("Test Heal and Upgrade Control")
    void testMove(){
        player.setCanHeal(true);
        HealUpgradeCalculator healUpgradeCalculator= new HealUpgradeCalculator(player);
        HealingUpgradingControl control = new HealingUpgradingControl(player, healUpgradeCalculator);
        player.changeCurrHitPoint(-20);
        healUpgradeCalculator.updateInfo();
        control.keyPressed("H");
        Assertions.assertEquals(player.getCurrHitPoint(),100);
        control.keyPressed("1");
        Assertions.assertEquals(player.getEquipment("Weapon").getStatValue(),1020);
        control.keyPressed("2");
        Assertions.assertEquals(player.getEquipment("Armor").getStatValue(),25);
        control.keyPressed("N");
        Assertions.assertEquals(player.getCanHeal(), false);
        Assertions.assertEquals(player.getCanUpgrade(), false);
    }
}
