package entity_tests;

import entity.Armor;
import entity.BasicEquipmentSlots;
import entity.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicEquipmentSlotsTest {
    Armor armor = new Armor("Chain Mail", 5);
    Weapon excalibur = new Weapon("Legendary Sword Excalibur", 1000);
    BasicEquipmentSlots equipmentSlots;

    @BeforeEach
    @DisplayName("Creates the same BasicEquipmentSlot Class before each test")
    void setUp(){
        equipmentSlots = new BasicEquipmentSlots(excalibur, armor);
    }

    @Test
    @DisplayName("Test Get Armor")
    void testGetArmor(){
        Assertions.assertEquals(armor, equipmentSlots.getArmor());
    }

    @Test
    @DisplayName("Test Get Weapon")
    void testGetWeapon(){
        Assertions.assertEquals(excalibur, equipmentSlots.getWeapon());
    }

    @Test
    @DisplayName("Test Set Armor")
    void testSetArmor(){
        Armor aegisShield = new Armor("Aegis Shield", 600000);
        equipmentSlots.setArmor(aegisShield);
        Assertions.assertEquals(aegisShield, equipmentSlots.getArmor());
    }

    @Test
    @DisplayName("Test Set Weapon")
    void testSetWeapon(){
        Weapon durandal = new Weapon("Legendary Sword Durandal", 1000);
        equipmentSlots.setWeapon(durandal);
        Assertions.assertEquals(durandal, equipmentSlots.getWeapon());
    }
}
