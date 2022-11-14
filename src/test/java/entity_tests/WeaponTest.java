package entity_tests;

import entity.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeaponTest {
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
}