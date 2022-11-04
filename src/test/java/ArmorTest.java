import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
    Armor shield = new Armor("shield", 1, 10);

    @Test
    void TestGetStatType(){
        assertEquals("DamageReduction", shield.getStatType());
    }

    @Test
    void TestGetDmgReduced(){
        assertEquals(10, shield.getDmgReduced());
    }
}