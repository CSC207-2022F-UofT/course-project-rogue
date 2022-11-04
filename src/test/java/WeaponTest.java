import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    Weapon sword = new Weapon("weapon", 1, 25);

    @Test
    void TestGetStatType(){
        assertEquals("Attack", sword.getStatType());
    }

    @Test
    void TestGetWeaponAttackPoint(){
        assertEquals(25, sword.getWeaponAttackPoint());
    }

}