package entity_tests;

import entity.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeaponTest {
    Weapon spear = new Weapon("weapon", 20);
    Weapon sword = new Weapon("weapon", 25);

    @Test
    void testGetStatValue(){Assertions.assertEquals(25, sword.getStatValue());}
    @Test
    void testGetStatType(){
        Assertions.assertEquals("Attack", sword.getStatType());
    }

    @Test
    void testSetStatValueGreaterThanPreviousValue(){
        sword.setStatValue(30);
        Assertions.assertEquals(30, sword.getStatValue());
    }
    @Test
    void testSetStatValueLesserThanPreviousValue(){
        sword.setStatValue(20);
        Assertions.assertEquals(20, sword.getStatValue());
    }

    @Test
    void testAddStatValueIncrease(){
        sword.addStatValue(10);
        Assertions.assertEquals(35, sword.getStatValue());
    }

    @Test
    void testAddStatValueDecrease(){
        sword.addStatValue(-10);
        Assertions.assertEquals(15, sword.getStatValue());

    }

    @Test
    void testCompareToGreaterThan(){
        Assertions.assertEquals(1, sword.compareTo(spear));
    }

    @Test
    void TestCompareToLessThan(){
        spear.addStatValue(10);
        Assertions.assertEquals(-1, sword.compareTo(spear));
    }

    @Test
    void TestCompareToEqual(){
        spear.setStatValue(sword.getStatValue());
        Assertions.assertEquals(0, sword.compareTo(spear));
    }

    @Test
    void TestGetTimesUpgraded(){
        Assertions.assertEquals(0, sword.getTimesUpgraded());
    }

    @Test
    void TestSetTimesUpgraded(){
        sword.setTimesUpgraded(2);
        Assertions.assertEquals(2, sword.getTimesUpgraded());
    }
}