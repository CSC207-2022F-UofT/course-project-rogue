package entity_tests;

import entity.Armor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArmorTest {
    Armor otherShield = new Armor("otherShield", 5);
    Armor shield = new Armor("shield", 10);

    @Test
    void testGetStatValue(){Assertions.assertEquals(10, shield.getStatValue());}

    @Test
    void testGetStatType(){
        Assertions.assertEquals("DamageReduction", shield.getStatType());
    }

    @Test
    void testSetStatValueGreaterThanPreviousValue(){
        shield.setStatValue(15);
        Assertions.assertEquals(15, shield.getStatValue());
    }

    @Test
    void testSetStatValueLesserThanPreviousValue(){
        shield.setStatValue(5);
        Assertions.assertEquals(5, shield.getStatValue());
    }
    @Test
    void testAddStatValueIncrease(){
        shield.addStatValue(10);
        Assertions.assertEquals(20, shield.getStatValue());
    }

    @Test
    void testAddStatValueDecrease(){
        shield.addStatValue(-10);
        Assertions.assertEquals(0, shield.getStatValue());
    }

    @Test
    void testCompareToGreaterThan(){
        Assertions.assertEquals(1, shield.compareTo(otherShield));
    }

    @Test
    void testCompareToLessThan(){
        otherShield.addStatValue(10);
        Assertions.assertEquals(-1, shield.compareTo(otherShield));
    }

    @Test
    void testCompareEqual(){
        otherShield.setStatValue(shield.getStatValue());
        Assertions.assertEquals(0, shield.compareTo(otherShield));
    }

    @Test
    void testGetTimesUpgraded(){
        Assertions.assertEquals(0, shield.getTimesUpgraded());
    }

    @Test
    void testSetTimesUpgraded(){
        shield.setTimesUpgraded(1);
        Assertions.assertEquals(1, shield.getTimesUpgraded());
    }
}