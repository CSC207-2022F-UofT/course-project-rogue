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
import usecase_essence_use.essenceUseCalculatorFactory;
import usecase_essence_use.essenceUseManager;
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
        map = new Map();
    }
    @Test
    @DisplayName("Test Heal and Upgrade Control: Heal")
    void testHealUpgradeControlHeal(){
        player.setCanHeal(true);
        player.setCanUpgrade(true);
        essenceUseCalculatorFactory essenceUseCalculatorFactory = new essenceUseCalculatorFactory(player);
        essenceUseManager control = new essenceUseManager(player, essenceUseCalculatorFactory);
        player.changeCurrHitPoint(-20);
        essenceUseCalculatorFactory.updateInfo();
        control.keyPressed("H");
        Assertions.assertEquals(player.getCurrHitPoint(),100);
    }

    @Test
    @DisplayName("Test Heal and Upgrade Control: WeaponUpgrade")
    void testHealUpgradeControlWeapon(){
        player.setCanHeal(true);
        player.setCanUpgrade(true);
        essenceUseCalculatorFactory essenceUseCalculatorFactory = new essenceUseCalculatorFactory(player);
        essenceUseManager control = new essenceUseManager(player, essenceUseCalculatorFactory);
        player.changeCurrHitPoint(-20);
        essenceUseCalculatorFactory.updateInfo();
        control.keyPressed("1");
        Assertions.assertEquals(player.getWeapon().getStatValue(),1020);
    }

    @Test
    @DisplayName("Test Heal and Upgrade Control: ArmorUpgrade")
    void testHealUpgradeControlArmor(){
        player.setCanHeal(true);
        player.setCanUpgrade(true);
        essenceUseCalculatorFactory essenceUseCalculatorFactory = new essenceUseCalculatorFactory(player);
        essenceUseManager control = new essenceUseManager(player, essenceUseCalculatorFactory);
        player.changeCurrHitPoint(-20);
        essenceUseCalculatorFactory.updateInfo();
        control.keyPressed("2");
        Assertions.assertEquals(player.getArmor().getStatValue(),25);
    }

    @Test
    @DisplayName("Test Heal and Upgrade Control: Leave")
    void testHealUpgradeControlEnd(){
        player.setCanHeal(true);
        player.setCanUpgrade(true);
        essenceUseCalculatorFactory essenceUseCalculatorFactory = new essenceUseCalculatorFactory(player);
        essenceUseManager control = new essenceUseManager(player, essenceUseCalculatorFactory);
        player.changeCurrHitPoint(-20);
        essenceUseCalculatorFactory.updateInfo();
        control.keyPressed("N");
        Assertions.assertFalse(player.getCanHeal());
        Assertions.assertFalse(player.getCanUpgrade());
    }
}
