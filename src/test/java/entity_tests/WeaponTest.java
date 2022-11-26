package entity_tests;

import entity.item.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeaponTest {
    Weapon spear = new Weapon("weapon", 20);
    Weapon sword = new Weapon("weapon", 25);

    @Test
    @DisplayName("Test Get Stat Value")
    void testGetStatValue(){Assertions.assertEquals(25, sword.getStatValue());}
    @Test
    @DisplayName("Test Get Stat Type")
    void testGetStatType(){
        Assertions.assertEquals("Attack", sword.getStatType());
    }

    @Test
    @DisplayName("Test Set Stat Value Greater Than Previous Value")
    void testSetStatValueGreaterThanPreviousValue(){
        sword.setStatValue(30);
        Assertions.assertEquals(30, sword.getStatValue());
    }
    @Test
    @DisplayName("Test Set Value Lesser Than Previous Value")
    void testSetStatValueLesserThanPreviousValue(){
        sword.setStatValue(20);
        Assertions.assertEquals(20, sword.getStatValue());
    }

    @Test
    @DisplayName("Test Add Stat Value Increase")
    void testAddStatValueIncrease(){
        sword.addStatValue(10);
        Assertions.assertEquals(35, sword.getStatValue());
    }

    @Test
    @DisplayName("Test Add Stat Value Decrease")
    void testAddStatValueDecrease(){
        sword.addStatValue(-10);
        Assertions.assertEquals(15, sword.getStatValue());

    }

    @Test
    @DisplayName("Test Compare Weapon, Greater Than")
    void testCompareToGreaterThan(){
        Assertions.assertEquals(1, sword.compareTo(spear));
    }

    @Test
    @DisplayName("Test Compare Weapon, Lesser Than")
    void testCompareToLessThan(){
        spear.addStatValue(10);
        Assertions.assertEquals(-1, sword.compareTo(spear));
    }

    @Test
    @DisplayName("Test Compare Weapon, Equal to")
    void testCompareToEqual(){
        spear.setStatValue(sword.getStatValue());
        Assertions.assertEquals(0, sword.compareTo(spear));
    }

    @Test
    @DisplayName("Test Get Times Upgraded")
    void testGetTimesUpgraded(){
        Assertions.assertEquals(0, sword.getTimesUpgraded());
    }

    @Test
    @DisplayName("Test Set Times Upgraded")
    void testSetTimesUpgraded(){
        sword.setTimesUpgraded(2);
        Assertions.assertEquals(2, sword.getTimesUpgraded());
    }
}