package entity_tests;

import entity.Monster.Monster;
import entity.Monster.Power;
import entity.Monster.Steal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

class MonsterTest {
    int[] atkStat = new int[]{1, 5};
    int[] hpStat = new int[]{1, 5};
    HashMap<String, int[]> stats = new HashMap<>(Map.ofEntries(
                                                                entry("Attack", atkStat),
                                                                entry("Health", hpStat)));
    String[] items = new String[]{"Essence"};
    Power power = new Steal(items);

    Monster monster = new Monster("Slime", "Basic", stats, false);
    Monster special = new Monster("Stealer", "Basic", stats, true, power);

    @Test
    void TestMonsterGetNameType() {
        Assertions.assertAll("Should return Monster name and type",
                () -> Assertions.assertEquals("Slime", monster.getName()),
                () -> Assertions.assertEquals("Basic", monster.getType())
        );
    }

    @Test
    void TestMonsterGetStats(){
        Assertions.assertAll("Should return an int within the max and min bounds.",
                () -> Assertions.assertTrue(monster.getAttack() >= 1 && monster.getAttack() <= 5),
                () -> Assertions.assertTrue(monster.getHealth() >= 1 && monster.getAttack() <= 5)
        );
    }

    @Test
    void TestMonsterHasPower(){
        Assertions.assertFalse(monster.isHasPower());
        Assertions.assertTrue(special.isHasPower());
    }

    @Test
    void TestMonsterGetPower(){
        Assertions.assertEquals(power, special.getPower());
    }
}
