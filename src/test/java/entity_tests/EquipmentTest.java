package entity_tests;

import entity.Equipment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {
    Equipment helmet = new Equipment("helmet", 1, "DamageReduction", 10);

    @Test
    void TestGetStatType(){
        Assertions.assertEquals("DamageReduction", helmet.getStatType());
    }

    @Test
    void TestGetStatValue(){
        Assertions.assertEquals(10, helmet.getStats());
    }
}