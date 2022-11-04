package entity_tests;

import entity.Armor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
    Armor shield = new Armor("shield", 1, 10);

    @Test
    void TestGetStatType(){
        Assertions.assertEquals("DamageReduction", shield.getStatType());
    }

    @Test
    void TestGetDmgReduced(){
        Assertions.assertEquals(10, shield.getDmgReduced());
    }
}