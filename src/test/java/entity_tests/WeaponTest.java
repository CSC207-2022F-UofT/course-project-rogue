package entity_tests;

import entity.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeaponTest {
    Weapon sword = new Weapon("weapon", 25);

    @Test
    void testGetStatType(){
        Assertions.assertEquals("Attack", sword.getStatType());
    }

    @Test
    void testGetWeaponAttackPoint(){
        Assertions.assertEquals(25, sword.getWeaponAttackPoint());
    }

}