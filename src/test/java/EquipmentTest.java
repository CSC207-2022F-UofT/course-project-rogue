import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {
    Equipment helmet = new Equipment("helmet", 1, "DamageReduction", 10);

    @Test
    void TestGetStats() {
        assertEquals(helmet.getStats().get("DamageReduction"), 10);
    }

    @Test
    void TestGetStatType(){

    }

    @Test
    void TestGetStatValue(){

    }
}