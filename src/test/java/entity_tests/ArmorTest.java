package entity_tests;

import entity.Armor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArmorTest {
    Armor shield = new Armor("shield", 10);

    @Test
    void testGetStatType(){
        Assertions.assertEquals("DamageReduction", shield.getStatType());
    }

    @Test
    void testGetDmgReduced(){
        Assertions.assertEquals(10, shield.getDmgReduced());
    }
}