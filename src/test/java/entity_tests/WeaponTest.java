package entity_tests;

import entity.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    Weapon sword = new Weapon("weapon", 25);

    @Test
    void TestGetStatType(){
        Assertions.assertEquals("Attack", sword.getStatType());
    }

    @Test
    void TestGetWeaponAttackPoint(){
        Assertions.assertEquals(25, sword.getWeaponAttackPoint());
    }

}