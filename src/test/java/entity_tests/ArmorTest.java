package entity_tests;

import entity.Armor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArmorTest {
    Armor otherShield = new Armor("otherShield", 5);
    Armor shield = new Armor("shield", 10);

    @Test
    @DisplayName("Test Get Stat Value")
    void testGetStatValue(){Assertions.assertEquals(10, shield.getStatValue());}

    @Test
    @DisplayName("Test Get Stat Type")
    void testGetStatType(){
        Assertions.assertEquals("DamageReduction", shield.getStatType());
    }

    @Test
    @DisplayName("Test Set Stat Value Greater Than Previous Value")
    void testSetStatValueGreaterThanPreviousValue(){
        shield.setStatValue(15);
        Assertions.assertEquals(15, shield.getStatValue());
    }

    @Test
    @DisplayName("Test Set Stat Value Lesser Than Previous Value")
    void testSetStatValueLesserThanPreviousValue(){
        shield.setStatValue(5);
        Assertions.assertEquals(5, shield.getStatValue());
    }
    @Test
    @DisplayName("Test Add Stat Value Increase")
    void testAddStatValueIncrease(){
        shield.addStatValue(10);
        Assertions.assertEquals(20, shield.getStatValue());
    }

    @Test
    @DisplayName("Test Add Stat Value Decrease")
    void testAddStatValueDecrease(){
        shield.addStatValue(-10);
        Assertions.assertEquals(0, shield.getStatValue());
    }

    @Test
    @DisplayName("Test Compare to Greater Than")
    void testCompareToGreaterThan(){
        Assertions.assertEquals(1, shield.compareTo(otherShield));
    }

    @Test
    @DisplayName("Test Compare to Lesser Than")
    void testCompareToLessThan(){
        otherShield.addStatValue(10);
        Assertions.assertEquals(-1, shield.compareTo(otherShield));
    }

    @Test
    @DisplayName("Test Compare to Equal to")
    void testCompareEqual(){
        otherShield.setStatValue(shield.getStatValue());
        Assertions.assertEquals(0, shield.compareTo(otherShield));
    }

    @Test
    @DisplayName("Test Get Times Upgraded")
    void testGetTimesUpgraded(){
        Assertions.assertEquals(0, shield.getTimesUpgraded());
    }

    @Test
    @DisplayName("Test Set Times Upgraded")
    void testSetTimesUpgraded(){
        shield.setTimesUpgraded(1);
        Assertions.assertEquals(1, shield.getTimesUpgraded());
    }
}